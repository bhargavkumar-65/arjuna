package com.autocognite.pvt.batteries.networker.lib.http;

import com.autocognite.pvt.batteries.networker.api.KeyValueQueue;
import com.autocognite.pvt.batteries.networker.lib.util.AbstractKVQueue;
import com.autocognite.pvt.batteries.networker.lib.util.FormParam;
import com.autocognite.pvt.batteries.networker.lib.util.KeyValuePair;

public class AcHttpHeaders extends AbstractKVQueue{
	public static final String	USER_AGENT	= "User-Agent";	
	public static final String	AUTHORIZATION = "Authorization";
	public static final String	HOST = "Host";
	public static final String	REFERER	= "Referer";
	public static final String	SERVER	= "Server";
	
	@Override
	public void add(String name, String value) {
		this.add(new AcHttpHeader(name, value));
	}

}
/*
public static final String	AGE	"Age"
public static final String	ALLOW	"Allow"

public static final String	CACHE_CONTROL	"Cache-Control"
public static final String	CONNECTION	"Connection"
public static final String	CONTENT_ENCODING	"Content-Encoding"
public static final String	CONTENT_LANGUAGE	"Content-Language"
public static final String	CONTENT_LENGTH	"Content-Length"
public static final String	CONTENT_LOCATION	"Content-Location"
public static final String	CONTENT_MD5	"Content-MD5"
public static final String	CONTENT_RANGE	"Content-Range"
public static final String	CONTENT_TYPE	"Content-Type"
public static final String	DATE	"Date"
public static final String	DAV	"Dav"
public static final String	DEPTH	"Depth"
public static final String	DESTINATION	"Destination"
public static final String	ETAG	"ETag"
public static final String	EXPECT	"Expect"
public static final String	EXPIRES	"Expires"
public static final String	FROM	"From"
public static final String	IF	"If"
public static final String	IF_MATCH	"If-Match"
public static final String	IF_MODIFIED_SINCE	"If-Modified-Since"
public static final String	IF_NONE_MATCH	"If-None-Match"
public static final String	IF_RANGE	"If-Range"
public static final String	IF_UNMODIFIED_SINCE	"If-Unmodified-Since"
public static final String	LAST_MODIFIED	"Last-Modified"
public static final String	LOCATION	"Location"
public static final String	LOCK_TOKEN	"Lock-Token"
public static final String	MAX_FORWARDS	"Max-Forwards"
public static final String	OVERWRITE	"Overwrite"
public static final String	PRAGMA	"Pragma"
public static final String	PROXY_AUTHENTICATE	"Proxy-Authenticate"
public static final String	PROXY_AUTHORIZATION	"Proxy-Authorization"
public static final String	RANGE	"Range"
public static final String	RETRY_AFTER	"Retry-After"
public static final String	STATUS_URI	"Status-URI"
public static final String	TE	"TE"
public static final String	TIMEOUT	"Timeout"
public static final String	TRAILER	"Trailer"
public static final String	TRANSFER_ENCODING	"Transfer-Encoding"
public static final String	UPGRADE	"Upgrade"
public static final String	VARY	"Vary"
public static final String	VIA	"Via"
public static final String	WARNING	"Warning"
public static final String	WWW_AUTHENTICATE	"WWW-Authenticate"
*/