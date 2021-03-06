package org.mule.raml.impl.v10.model;

import org.mule.raml.model.DocumentationItem;
import org.raml.v2.api.model.v10.system.types.MarkdownString;

public class DocumentationItemImpl implements DocumentationItem
{

    private org.raml.v2.api.model.v10.api.DocumentationItem doc;

    public DocumentationItemImpl(org.raml.v2.api.model.v10.api.DocumentationItem doc)
    {
        this.doc = doc;
    }

    @Override
    public String getContent()
    {
        final MarkdownString content = doc.content();
        return content != null ? content.value() : null;
    }
}
