/*
 *	MSS Code Factory CFLib 2.13 JavaFX Support
 *
 *	Copyright (C) 2016-2025 Mark Stephen Sobkow (mailto:mark.sobkow@gmail.com)
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

import java.util.*;
import javafx.geometry.Pos;

import org.msscf.msscf.v2_13.cflib.CFLib.*;
import org.msscf.msscf.v2_13.cflib.CFLib.xml.*;

public class CFUuidEditor
extends CFTextField
{
	protected UUID value = null;

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
	
	public CFUuidEditor() {
		super();
		setAlignment( Pos.CENTER_LEFT );
		setMinWidth( 200 );
		setPrefWidth( 300 );
		setMaxWidth( 370 );
		setMinHeight( 25 );
		setMaxHeight( 25 );
		setPrefHeight( 25 );
	}
	
	public void setUuidValue( UUID val ) {
		value = val;
		String str;
		if( value != null ) {
			str = value.toString();
		}
		else {
			str = "";
		}
		setText( str );
	}
	
	public UUID getUuidValue() {
		final String S_ProcName = "getUuidValue";
		String str = getText();
		if( ( str == null ) || ( str.length() <= 0 ) ) {
			value = null;
		}
		else {
			try {
				UUID val = UUID.fromString( str );
				if( val == null ) {
					throw new CFLibInvalidArgumentException( fieldName,
							S_ProcName,
							0,
							"text",
							getText() );
				}
				value = val;
			}
			catch( Exception e ) {
				throw new CFLibInvalidArgumentException( fieldName,
						S_ProcName,
						0,
						"text",
						getText() );
			}
		}
		return( value );
	}
}
