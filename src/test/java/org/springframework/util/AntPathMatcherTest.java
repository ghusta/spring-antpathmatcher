package org.springframework.util;

import org.junit.Assert;
import org.junit.Test;

public class AntPathMatcherTest
{

    @Test
    public void match() throws Exception
    {
        final AntPathMatcher antPathMatcher = new AntPathMatcher();
        boolean match;

        match = antPathMatcher.match("/path/**", "/path/must/match");
        Assert.assertTrue(match);

        match = antPathMatcher.match("/path/**", "path/don-t/match");
        Assert.assertFalse(match);

        match = antPathMatcher.match("/scripts/**/*.{js,html}", "/scripts/jquery/jquery-min.js");
        Assert.assertTrue(match);

        match = antPathMatcher.match("/scripts/**/*.{js,html}", "/scripts/jquery/jquery-doc.html");
        Assert.assertTrue(match);
    }

}