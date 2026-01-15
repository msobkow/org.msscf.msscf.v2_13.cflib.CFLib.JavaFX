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

import javafx.geometry.Pos;

import org.msscf.msscf.v2_13.cflib.CFLib.*;
import org.msscf.msscf.v2_13.cflib.CFLib.xml.*;

public class CFNmTokenEditor
extends CFTextField
{
	protected int maxLen = 1;

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

	public CFNmTokenEditor() {
		super();
		setAlignment( Pos.CENTER_LEFT );
	}
	
	public int getMaxLen() {
		return( maxLen );
	}

	public void setMaxLen( int value ) {
		final String S_ProcName = "setMaxLen";
		if( maxLen < 1 ) {
			throw new CFLibArgumentUnderflowException( fieldName,
					S_ProcName,
					1,
					fieldName,
					value,
					1 );
		}
		maxLen = value;
		if( maxLen > 58 ) {
			setPrefWidth( 660 );
		}
		else if( maxLen > 0 ) {
			setPrefWidth( ( maxLen + 2 ) * 11 );
		}
	}
	
	public boolean hasValue() {
		boolean retval;
		String text = getText();
		if( ( text == null ) || ( text.length() <= 0 ) ) {
			retval = false;
		}
		else {
			retval = true;
		}
		return( retval );
	}
	
	public boolean isEditValid() {
		String str = getText();
		if( str == null ) {
			return( true );
		}
		
		int len = str.length();
		if( len > maxLen ) {
			return( false );
		}
		else {
			return( true );
		}
	}
	
	public void setNmTokenValue( String value ) {
		if( value != null ) {
			setText( value );
		}
		else {
			setText( "" );
		}
	}

	public String getNmTokenValue() {
		final String S_ProcName = "getNmTokenValue";
		String text = getText();
		if( text == null ) {
			return( null );
		}
		else if( text.length() > maxLen ) {
			throw new CFLibArgumentOverflowException( fieldName,
					S_ProcName,
					0,
					"MaxLen",
					text.length(),
					maxLen );
		}
		else {
			return( text );
		}
	}
}
