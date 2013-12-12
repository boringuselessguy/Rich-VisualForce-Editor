package com.vf.apex.editor.assist;

import java.util.ArrayList;
import java.util.List;

public class TagDefinations {

	public static List<Tag> getAllTagsDefinationList() {
		ArrayList<Tag> tagList = new ArrayList<Tag> ();
		tagList.addAll(VisualForceTagDefinition.getTagInfoAsList());
		tagList.addAll(HTMLFourTagDefination.getTagInfoAsList());
		return tagList;
	}
}
