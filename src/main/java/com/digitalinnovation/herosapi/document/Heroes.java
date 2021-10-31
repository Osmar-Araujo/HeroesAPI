package com.digitalinnovation.herosapi.document;

import org.springframework.data.annotation.Id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName="Heroes_Table")
public class Heroes {
	
	@Id
	@DynamoDBHashKey(attributeName = "id")
	private String id;
	
	@DynamoDBAttribute(attributeName = "name")
	private String name;
	
	@DynamoDBAttribute(attributeName = "universo")
	private String universo;
	
	@DynamoDBAttribute(attributeName = "filmes")
	private int filmes;

}
