package com.junit.test;

import org.junit.Assert;
import org.junit.Test;
import org.mule.tck.junit4.AbstractMuleContextTestCase;

public class TestJUnit extends AbstractMuleContextTestCase {

	@Test
	public void testJUnit() throws Exception {
		Assert.assertNotNull("help");
	}
	
}
