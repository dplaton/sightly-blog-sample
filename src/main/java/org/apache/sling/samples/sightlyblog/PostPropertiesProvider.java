/*******************************************************************************
 * ADOBE CONFIDENTIAL
 * __________________
 *
 * Copyright 2015 Adobe Systems Incorporated
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Adobe Systems Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Adobe Systems Incorporated and its
 * suppliers and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Adobe Systems Incorporated.
 ******************************************************************************/

package org.apache.sling.samples.sightlyblog;

import javax.script.Bindings;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.SyntheticResource;
import org.apache.sling.scripting.sightly.pojo.Use;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Your comment here
 */
public class PostPropertiesProvider implements Use{

    private static final Logger LOG = LoggerFactory.getLogger(PostPropertiesProvider.class);

    private Resource comments = null;
    private boolean isNew = true;

    public void init(Bindings bindings) {
        Resource currentResource = (Resource) bindings.get("resource");
        comments = currentResource.getChild("comments");
        isNew = (currentResource instanceof SyntheticResource);
    }

    public Resource getComments() {
        return comments;
    }

    public boolean hasComments() {
        return comments != null;
    }

    public boolean isNew() {
        return isNew;
    }
}
