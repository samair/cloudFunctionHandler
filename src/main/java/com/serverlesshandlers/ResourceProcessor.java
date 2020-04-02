package com.serverlesshandlers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.serverlesshandlers.annotations.RestHandlerMapping;
import com.serverlesshandlers.awsresources.Function;
import com.serverlesshandlers.awsresources.FunctionSchema;
import com.serverlesshandlers.awsresources.Trigger;
import com.serverlesshandlers.awsresources.Type;



@SupportedAnnotationTypes({"com.serverlesshandlers.annotations.RestHandlerMapping"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ResourceProcessor extends AbstractProcessor{
	private Messager messager;
	@Override
	public synchronized  void init(ProcessingEnvironment env) {
	
		messager = env.getMessager();
		
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		

		 Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(RestHandlerMapping.class);
		 
		 
		 FunctionSchema schema = new FunctionSchema();
		 schema.setRunEnv("java8");
		 schema.setProvider("aws");
		 
		
		 Function func = new Function();
		 func.setName("productFunction");
		 
		
		 
		List<Trigger> triggers = new ArrayList<> ();
		 
		 for (Element element : annotatedElements) {
	            if (element.getKind() == ElementKind.CLASS) {
	            	
	            	for (AnnotationMirror mirror : element.getAnnotationMirrors()) {
	            		
	            		
	            		Map<? extends ExecutableElement, ? extends AnnotationValue> elemVals = mirror.getElementValues();
	            		Trigger trigger = new Trigger();
	            		trigger.setType(Type.REST);
	            		 for (Entry<? extends ExecutableElement, ? extends AnnotationValue> e : elemVals.entrySet()) {
	            			 
	            			 Name name = e.getKey().getSimpleName();
	            			 
	            			 if (name.contentEquals("path")) {
	            				 trigger.setPath(e.getValue().toString()); 
	            			 }
	            			 else if (name.contentEquals("httpMethod")) {
	            				 trigger.setMethod(e.getValue().toString());
	            			 }
	 
	            		 }
	            		 triggers.add(trigger);
	            		 System.out.println(trigger.toString());
	            		
	            	}
	            	func.setTrigger(triggers);
	       		 System.out.println("Size of triggers:"+triggers.size());
	       		 schema.setFunction(func);
	       		 ObjectMapper om = new ObjectMapper(new YAMLFactory());
	       		 try {
	       			om.writeValue(new File("functionSchema.yaml"), schema);
	       			
	       			
	       		} catch (IOException e1) {
	       			// TODO Auto-generated catch block
	       			e1.printStackTrace();
	       		}    
	            }
	        }
		 
		  
		 return true;
	}

}
