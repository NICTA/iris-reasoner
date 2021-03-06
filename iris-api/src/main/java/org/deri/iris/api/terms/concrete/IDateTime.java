/*
 * Integrated Rule Inference System (IRIS):
 * An extensible rule inference system for datalog with extensions.
 * 
 * Copyright (C) 2008 Semantic Technology Institute (STI) Innsbruck, 
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
package org.deri.iris.api.terms.concrete;

import java.util.TimeZone;

import javax.xml.datatype.XMLGregorianCalendar;

import org.deri.iris.api.terms.IConcreteTerm;

/**
 * This is a representation of the builtin datatype IDateTime.
 * <p>
 * Remark: IRIS supports datatypes according to the standard 
 * specification for primitive XML Schema datatypes.
 * </p>
 * <br />
 * <code>ATTENTION: internally a Calendar is
 * used, so setting month and hour is zero-based.</code>
 * <br />
 * <code>ATTENTION: set the correct timezone</code>
 */
public interface IDateTime extends IConcreteTerm
{
	/**
	 * Return the wrapped type.
	 */
	XMLGregorianCalendar getValue();

	/**
	 * Returns the year.
	 * 
	 * @return the year
	 */
	int getYear();

	/**
	 * Returns the month of the year.
	 * 
	 * @return the month (zero-based)
	 */
	int getMonth();

	/**
	 * Returns the day of the month.
	 * 
	 * @return the day
	 */
	int getDay();

	/**
	 * Returns the hour of the day.
	 * 
	 * @return the hours (zero-based)
	 */
	int getHour();

	/**
	 * Returns the minute of the hour
	 * 
	 * @return the minutes
	 */
	int getMinute();

	/**
	 * Returns the seconds of the minute.
	 * 
	 * @return the seconds
	 */
	int getSecond();

	/**
	 * Returns the milliseconds of the second.
	 * @return the milliseconds
	 */
	int getMillisecond();
	
	/**
	 * Return the complete floating point representation of the seconds components.
	 * @return Decimal seconds
	 */
	double getDecimalSecond();

	/**
	 * Returns the Timezone
	 * 
	 * @return the timezone
	 */
	TimeZone getTimeZone();
}
