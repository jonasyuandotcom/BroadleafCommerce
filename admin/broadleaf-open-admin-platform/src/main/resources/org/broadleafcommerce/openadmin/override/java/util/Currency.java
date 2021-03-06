/*
 * Copyright 2008-2009 the original author or authors.
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

package java.util;

import java.io.Serializable;

/**
 * A simple, GWT compatible version of the Currency class
 * 
 * @author jfischer
 *
 */
public class Currency implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static Currency getInstance(String currencyCode) {
		Currency currency = new Currency();
		currency.currencyCode = currencyCode;
		return currency;
	}
	
	private String currencyCode;

	public String getCurrencyCode() {
		return currencyCode;
	}

}
