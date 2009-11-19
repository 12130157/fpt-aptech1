/*
 * TreXanh JavaScript Library
 * Written by NGUYEN, Ba Thanh <btnguyen@diendantinhoc.net>
 * Copyright (C) DienDanTinHoc.NET & DDTH.ORG
 *
 * HTML Form-related library
 *
 * Version $Id: TXLib_Form.js,v 1.1 2005/12/27 07:57:12 btnguyen Exp $
 */

/*
 * Toggles all checkboxes which share a same name.
 * @param indicator a checkbox
 * @param checkboxes checkboxes to toggle
 */
function txbbForm_ToggleCheckboxes(indicator, checkboxes) {
	for ( var i = 0; i < checkboxes.length; i++ ) {
		checkboxes[i].checked = indicator.checked;
	} //end for
} //end txbbForm_ToggleAllCheckboxes

/*
 * Returns true if a string is an identifier ([A-Za-z0-9_]+),
 * returns false otherwise
 */
function txbbForm_ValidateIsIdentifer(str) {
	if ( !str.match(/^\s*\w+\s*$/) ) return false;
	else return true;
} //end txbbForm_ValidateIsIdentifer

/*
 * Returns true if a string is an integer (-?[0-9]+),
 * returns false otherwise
 */
function txbbForm_ValidateIsInteger(str) {
	if ( !str.match(/^\s*\-?[0-9]+\s*$/i) ) return false;
	return true;
} //end txbbForm_ValidateIsInteger

/*
 * Returns true if length of a string does not exceed limit,
 * returns false otherwise
 */
function txbbForm_ValidateLength(str, maxLen) {
	str = str.replace(/^\s+/g, '');
	str = str.replace(/\s+$/g, '');
	if ( str.length > maxLen ) return false;
	return true;
} //end txbbForm_ValidateLength

/*
 * Returns true if a string is not empty,
 * returns false otherwise
 */
function txbbForm_ValidateRequire(str) {
	str = str.replace(/^\s+/g, '');
	str = str.replace(/\s+$/g, '');
	if (str == '') return false;
	else return true;
} //end txbbForm_ValidateRequire

/*
 * Clears a form field (set its value to empty string)
 * Call:
 *    txbbForm_ClearField(document.formName.fieldName)
 */
function txbbForm_ClearField(field) {
	field.value = '';
} //end txbbForm_ClearField

/*
 * Disables a form field (set its disabled or readonly attribute to TRUE)
 * Call:
 *    txbbForm_DisableField(document.formName.fieldName)
 */
function txbbForm_DisableField(field) {
	if ( field.disabled != null ) field.disabled = true;
	else field.readOnly = true;
} //end txbbForm_DisableField

/*
 * Enables form field (set its disabled or readonly attribute to FALSE)
 * Call:
 *    txbbForm_EnableField(document.formName.fieldName)
 */
function txbbForm_EnableField(field) {
	if ( field.disabled != null ) field.disabled = false;
	else field.readOnly = false;
} //end txbbForm_EnableField

/**
 * Selects all entried in a select field: <select>...</select>
 * @param selectField the form's select field object.
 */
function txbbForm_SelectAll(selectField) {
	var i;
	for ( i = 0; i < selectField.length; i++ )	{
		selectField.options[i].selected = true;
	} //end for
} //end txbbForm_SelectAll

/**
 * Deselects all entried in an select field: <select>...</select>
 * @param selectField the form's select field object.
 */
function txbbForm_DeselectAll(selectField) {
	var i;
	for ( i = 0; i < selectField.length; i++ )	{
		selectField.options[i].selected = false;
	} //end for
} //end txbbForm_DeselectAll

/**
 * Select an entry from a select field whose value matches a supplied value.
 * @param selectField the form's select field object.
 * @param value the value to seach.
 */
function txbbForm_SelectEntry(selectField, value) {
	var i;
	for ( i = 0; i < selectField.length; i++ )	{
		if ( selectField.options[i].value == value )
			selectField.options[i].selected = true;
	} //end for
} //end txbbForm_SelectEntry

/*
 * Creates a selection list <select></select>
 * Call:
 *    document.write(txbbForm_CreateSelection(options))
 * Parameter:
 *   options - a TXLibHashtable contain following keys
 *     options['name'] - (string) name of the form element
 *     options['num_rows'] - (integer) number of rows (default is 1 = dropdown list)
 *     options['multiple'] - (boolean) allow multirow selection (no effect with dropdown list)
 *     options['rows'] - (array of pairs [value, display]) each row of the
 *       selection is a pair of the array
 *     options['default'] - (string) value of default seleted row
 *     options['class'] - (string) CSS class name attribute
 *     options['style'] - (string) style attribute
 *     options['event_handler'] - (string) the javascript code that will handle onEvent,
 *       note: the javascript source code will be insert "as-is" in to the form element,
 *       so handle with care for syntax errors and security stuff
 */
function txbbForm_CreateSelection(options) {
	var str = "";

	var num_rows = options.get('num_rows');
		if ( num_rows == null ) num_rows = 1;
		if ( num_rows < 1 ) num_rows = 1;
		if ( num_rows > 1) num_rows = ' size="'+num_rows+'"';
		else num_rows = '';

	var multiple = options.get('multiple');
		if ( multiple == null ) multiple = false;
		multiple &= true;
		if ( num_rows == '' || !multiple ) multiple = '';
		else multiple = ' multiple';

	var name = options.get('name');
		if ( name == null ) name = "";
		if ( name != "" ) name = ' name="'+name+'"';
		else name = "";

	var class_name = options.get('class');
		if ( class_name == null ) class_name = "";
		if ( class_name != "" ) class_name = ' class="'+class_name+'"';
		else class_name = "";

	var style = options.get('style');
		if ( style == null ) style = "";
		if ( style != "" ) style = ' style="'+style+'"';
		else style = "";

	var defaultRow = options.get('default');
		if ( defaultRow == null ) defaultRow = "";

	var eventHandler = options.get('event_handler');
		if ( eventHandler == null ) eventHandler = "";

	var rows = options.get('rows');
	var strRows = "";
	if ( rows == null ) strRows = "";
	else {
		var i;
		for ( i = 0; i<rows.length; i++ ) {
			strRows += '<option value="'+rows[i][0]+'"';
			if ( rows[i][0] == defaultRow ) strRows += ' selected';
			strRows += '>'+rows[i][1]+'</option>';
		} //end for
	} //end if

	str += "<select"+multiple+name+num_rows+class_name+style+eventHandler+">\n";
	str += strRows;
	str += "</select>\n";
	return str;
} //end txbbForm_CreateSelection

/*
 * Creates a group of radio buttons
 * Call:
 *    document.write(txbbForm_CreateRadioGroup(options))
 * Parameter:
 *   options - a TXLibHashtable contain following keys
 *     options['name'] - (string) name of the form element
 *     options['buttons'] - (array of [value, display, start_newline]) reach radio button
 *       contains the value of the button, the text to be displayed and a flag to indicate
 *       that the next button will be put on a new line or not
 *     options['default'] - (string) value of default seleted button
 *     options['class'] - (string) CSS class name attribute
 *     options['style'] - (string) style attribute
 *     options['event_handler'] - (string) the javascript code that will handle onEvent,
 *       note: the javascript source code will be insert "as-is" in to the form element,
 *       so handle with care for syntax errors and security stuff
 */
function txbbForm_CreateRadioGroup(options) {
	var str = "";

	var name = options.get('name');
		if ( name == null ) name = "";
		if ( name != "" ) name = ' name="'+name+'"';
		else name = "";

	var class_name = options.get('class');
		if ( class_name == null ) class_name = "";
		if ( class_name != "" ) class_name = ' class="'+class_name+'"';
		else class_name = "";

	var style = options.get('style');
		if ( style == null ) style = "";
		if ( style != "" ) style = ' class="'+style+'"';
		else style = "";

	var defaultButton = options.get('default');
		if ( defaultButton == null ) defaultRow = "";

	var eventHandler= options.get('event_handler');
		if ( eventHandler == null ) eventHandler = "";

	var buttons = options.get('buttons');
	var strButtons = "";
	if ( buttons == null ) strButtons = "";
	else {
		var i;
		for ( i = 0; i<buttons.length; i++ ) {
			strButtons += '<input type="radio"'+name+class_name+style+eventHandler+
				' value="'+buttons[i][0]+'"';
			if ( buttons[i][0] == defaultButton ) strButtons += ' checked';
			strButtons += '>'+buttons[i][1];
			if ( buttons[i][2] ) strButtons += '<br>';
		} //end for
	} //end if

	return strButtons;
} //end txbbForm_CreateRadioGroup
