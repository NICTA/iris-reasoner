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
package org.deri.iris.builtins.datatype;

import static org.deri.iris.factory.Factory.BASIC;
import static org.deri.iris.factory.Factory.CONCRETE;
import static org.deri.iris.factory.Factory.TERM;
import junit.framework.TestCase;

import org.deri.iris.EvaluationException;
import org.deri.iris.api.basics.ITuple;
import org.deri.iris.api.terms.ITerm;
import org.deri.iris.api.terms.concrete.ISqName;

/**
 * Test for ToBase64Builtin.
 */
public class ToBase64BuiltinTest extends TestCase {

	private static final ITerm X = TERM.createVariable("X");

	private static final ITerm Y = TERM.createVariable("Y");

	public ToBase64BuiltinTest(String name) {
		super(name);
	}

	public void testBase64() throws EvaluationException {
		equals("c3VyZS4=", CONCRETE.createBase64Binary("c3VyZS4="));
	}

	public void testBoolean() throws EvaluationException {
		fails(CONCRETE.createBoolean(true));
	}

	public void testDate() throws EvaluationException {
		fails(CONCRETE.createDate(2009, 04, 27));
	}

	public void testDateTime() throws EvaluationException {
		fails(CONCRETE.createDateTime(2009, 04, 27, 10, 10, 0, -5, 0));
	}

	public void testDayTimeDuration() throws EvaluationException {
		fails(CONCRETE.createDayTimeDuration(false, 2, 2, 3, 0));
		fails(CONCRETE.createDayTimeDuration(true, 0, 15, 0, 0));
	}

	public void testDecimal() throws EvaluationException {
		fails(CONCRETE.createDecimal(1.337));
	}

	public void testDouble() throws EvaluationException {
		fails(CONCRETE.createDouble(0.0));
	}

	public void testDuration() throws EvaluationException {
		fails(CONCRETE.createDuration(true, 2, 1, 0, 5, 4, 2.3));
	}

	public void testFloat() throws EvaluationException {
		fails(CONCRETE.createFloat(0.0f));
	}

	public void testGDay() throws EvaluationException {
		fails(CONCRETE.createGDay(27));
	}

	public void testGMonth() throws EvaluationException {
		fails(CONCRETE.createGMonth(4));
	}

	public void testGMonthDay() throws EvaluationException {
		fails(CONCRETE.createGMonthDay(4, 27));
	}

	public void testGYear() throws EvaluationException {
		fails(CONCRETE.createGYear(2009));
	}

	public void testGYearMonth() throws EvaluationException {
		fails(CONCRETE.createGYearMonth(2009, 4));
	}

	public void testHexBinary() throws EvaluationException {
		equals("0FB7", CONCRETE.createHexBinary("0FB7"));
	}

	public void testInteger() throws EvaluationException {
		fails(CONCRETE.createInteger(1337));
	}

	public void testIri() throws EvaluationException {
		fails(CONCRETE.createIri("http://www.w3.org/2007/rif#iri"));
	}

	public void testSqName() throws EvaluationException {
		ISqName name = CONCRETE.createSqName(CONCRETE
				.createIri("http://www.w3.org/2002/07/owl#"), "owl");
		fails(name);
	}

	public void testPlainLiteral() throws EvaluationException {
		fails(CONCRETE.createPlainLiteral("a text@en"));
	}

	public void testTime() throws EvaluationException {
		fails(CONCRETE.createTime(12, 45, 0, 0, 0));
	}

	public void testXMLLiteral() throws EvaluationException {
		fails(CONCRETE.createXMLLiteral("<quote>Bam!</quote>", "de"));
	}

	public void testYearMonthDuration() throws EvaluationException {
		fails(CONCRETE.createYearMonthDuration(true, 2009, 4));
	}

	private void equals(String expected, ITerm term) throws EvaluationException {
		ITuple expectedTuple = BASIC.createTuple(CONCRETE
				.createBase64Binary(expected));
		ITuple actualTuple = compute(term);

		assertEquals(expectedTuple, actualTuple);
	}

	private void fails(ITerm term) throws EvaluationException {
		assertNull(compute(term));
	}

	private ITuple compute(ITerm term) throws EvaluationException {
		ToBase64Builtin builtin = new ToBase64Builtin(term, Y);

		ITuple arguments = BASIC.createTuple(X, Y);
		ITuple actualTuple = builtin.evaluate(arguments);

		return actualTuple;
	}

}
