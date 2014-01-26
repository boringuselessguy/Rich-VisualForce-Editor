package com.vf.apex.editor.assist;

import java.util.ArrayList;
import java.util.List;

public class TagDefinitions {

	public static List<Tag> getAllTagsDefinitionList() {
		ArrayList<Tag> tagList = new ArrayList<Tag> ();
		tagList.addAll(VisualForceTagDefinition.getTagInfoAsList());
		tagList.addAll(HTMLTagDefinition.getTagInfoAsList());
		return tagList;
	}
}
