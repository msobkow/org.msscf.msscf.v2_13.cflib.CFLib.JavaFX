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

import javafx.scene.control.TableCell;

import org.msscf.msscf.v2_13.cflib.CFLib.*;

public class CFBoolTableCell<T>
extends TableCell<T,Boolean>
{
	@Override protected void updateItem( Boolean item, boolean empty ) {
		super.updateItem( item, empty );
		if( empty ) {
			setText( null );
			setStyle( "" );
		}
		else if( item == null ) {
			setText( "?" );
			setStyle( "-fx-alignment: CENTER" );
		}
		else {
			boolean value = item.booleanValue();
			String cellText;
			if( value ) {
				cellText = "T";
			}
			else {
				cellText = "F";
			}
			setText( cellText );
			setStyle( "-fx-alignment: CENTER" );
		}
	}
}
