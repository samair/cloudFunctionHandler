package com.github.samair.cludFunctionCreator;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.samair.cludFunctionCreator.aws.resources.Properties;
import com.github.samair.cludFunctionCreator.aws.resources.Resources;
import com.github.samair.cludFunctionCreator.aws.resources.RestAPI;
import com.github.samair.cludFunctionCreator.aws.resources.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Goal which touches a timestamp file.
 *
 * @goal touch
 * 
 * @phase process-sources
 */

@Mojo(name = "create", defaultPhase = LifecyclePhase.PACKAGE)
public class CloudFunctionMojo extends AbstractMojo {

	/**
	 * The git command used to retrieve the current commit hash.
	 */
	@Parameter(property = "provier", defaultValue = "aws")
	private String provider;
	@Parameter(property = "region", defaultValue = "aws")
	private String region;

	public void execute() throws MojoExecutionException {
		System.out.println("Generation Cloud formation JSON");
		ObjectMapper mapper = new ObjectMapper();

		
		//Read Generated JSON file
		
		try {
			ObjectMapper yamlMapper = new ObjectMapper();
			yamlMapper = new ObjectMapper(new YAMLFactory());
			FunctionSchema schema = yamlMapper.readValue(new File("functionSchema.yaml"), FunctionSchema.class);
			System.out.println("Schema:"+schema.toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Template template = new Template();
		template.setAWSTemplateFormatVersion("2010-09-09");
		
		
		Resources resources = new Resources();
		
		RestAPI productAPI = new RestAPI();
		Properties properties = new Properties();
		properties.setName("TestCloudFunction");
		productAPI.setProperties(properties);
		resources.setAdditionalProperty("AWSAPIGatewayRestAPI",productAPI);
		
		template.setResources(resources);

		try {
			mapper.writeValue(new File("Template.json"), template);
			
			String jsonInString = mapper.writeValueAsString(template);
			System.out.println(jsonInString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) throws MojoExecutionException {
		CloudFunctionMojo mojo = new CloudFunctionMojo();
		mojo.execute();
	}
}
