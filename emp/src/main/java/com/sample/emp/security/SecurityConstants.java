package com.sample.emp.security;


	import com.sample.emp.SpringApplicationContext;

	public class SecurityConstants
	{
		public static final long EXPIRATION_TIME=864000000; //10 Days
		public static final String TOKEN_PREFIX="Bearer ";
		public static final String HEADER_STRING="Authorization";
		public static final String SIGNUP_URL="/users"; 	
		public static final String H2_CONSOLE= "/h2-console/**";
		
		public static String getTokenSecret()
		{
			AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("appProperties");
			return appProperties.getTokenSecret();
		}

	}

