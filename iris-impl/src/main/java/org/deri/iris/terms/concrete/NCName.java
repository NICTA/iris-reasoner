/*
 * Integrated Rule Inference System (IRIS):
 * An extensible rule inference system for datalog with extensions.
 * 
 * Copyright (C) 2009 Semantic Technology Institute (STI) Innsbruck, 
 * University of Innsbruck, Technikerstrasse 21a, 6020 Innsbruck, Austria.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 */
package org.deri.iris.terms.concrete;

import java.net.URI;

import org.deri.iris.api.terms.concrete.INCName;
import org.deri.iris.api.terms.concrete.XmlSchemaDatatype;

/**
 * <p>
 * A simple implementation of NCName.
 * </p>
 * 
 * @author Adrian Marte
 */
public class NCName extends Name implements INCName {

	/**
	 * Creates a new NCName instance for the given NCName. Does not check for
	 * validity of the specified NCName.
	 * 
	 * @param name The string representing the NCName.
	 */
	public NCName(String name) {
		super(name);
	}

	@Override
	public URI getDatatypeIRI() {
		return XmlSchemaDatatype.NCNAME.toUri();
	}

}
