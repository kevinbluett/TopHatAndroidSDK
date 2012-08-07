package org.tophat.android.model;

import java.util.HashMap;
import java.util.Map;

import org.tophat.android.exceptions.HttpException;
import org.tophat.android.mapping.ApiToken;
import org.tophat.android.networking.ApiCommunicator;

public class ApiTokenMapper extends Mapper 
{
	public ApiTokenMapper(ApiCommunicator apic)
	{
		super(apic);
	}
	
	public ApiToken getApiToken(String username, String password) throws HttpException
	{
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("email", username);
		map.put("password", password);
		
		return new ApiToken(this.getApiCommunicator().post("apitokens/", map));
	}
}