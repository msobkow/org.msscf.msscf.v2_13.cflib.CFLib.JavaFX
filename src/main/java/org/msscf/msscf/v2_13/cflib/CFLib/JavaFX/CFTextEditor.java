/*
 *	MSS Code Factory CFLib 2.13 JavaFX Support
 *
 *	Copyright (C) 2016-2026 Mark Stephen Sobkow (mailto:mark.sobkow@gmail.com)
 *	
 *	This program is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	This program is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with this program.  If not, see &lt;https://www.gnu.org/licenses/&gt;.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package org.msscf.msscf.v2_13.cflib.CFLib.JavaFX;

import javafx.scene.control.TextArea;

import org.msscf.msscf.v2_13.cflib.CFLib.*;
import org.msscf.msscf.v2_13.cflib.CFLib.xml.*;

public class CFTextEditor
extends TextArea
{
	protected int maxLen = 0;

	protected String fieldName = "?";
	
	public String getFieldName() {
		return( fieldName );
	}
	
	public void setFieldName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			fieldName = "?";
		}
		else {
			fieldName = value;
		}
	}

	public CFTextEditor() {
		super();
		setPrefWidth( 660 );
		setMinHeight( 50 );
		setPrefHeight( 50 );
	}
	
	public void setTextValue( String text ) {
		final String S_ProcName = "setTextValue";
		if( text == null ) {
			setText( "" );
			return;
		}
		if( text.length() > maxLen ) {
			throw new CFLibArgumentOverflowException( fieldName,
				S_ProcName,
				"Maximum length of text editor is " + maxLen );
		}
		setText( text );
	}
	
	public String getTextValue() {
		String text = getText();
		return( text );
	}
	
	public int getMaxLen() {
		return( maxLen );
	}

	public void setMaxLen( int value ) {
		final String S_ProcName = "setMaxLen";
		if( value < 1 ) {
			throw new CFLibArgumentUnderflowException( fieldName,
					S_ProcName,
					1,
					"value",
					value,
					1 );
		}
		maxLen = value;
		String curText = getText();
		if( ( curText != null ) && ( curText.length() > maxLen ) ) {
			curText = curText.substring( 0, maxLen );
			setText( curText );
		}
	}
}
