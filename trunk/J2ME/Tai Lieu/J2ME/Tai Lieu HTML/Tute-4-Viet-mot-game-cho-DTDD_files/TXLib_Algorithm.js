/*
 * TreXanh JavaScript Library
 * Written by NGUYEN, Ba Thanh <btnguyen@diendantinhoc.net>
 * Copyright (C) DienDanTinHoc.NET & DDTH.ORG
 *
 * HTML Algorithm-related library
 *
 * Version $Id: TXLib_Algorithm.js,v 1.1 2005/12/27 07:57:12 btnguyen Exp $
 */

/*********************************************************************
Hashtable implementation in JavaScript
Based on Michael Synovic's code version 01/12/2003
*********************************************************************/
/*
 * Constructor: Creates a new, empty hashtable.
 */
function TXLibHashtable() {
	this.clear = _TXLibHashtable_clear;
	this.containsKey = _TXLibHashtable_containsKey;
	this.containsValue = _TXLibHashtable_containsValue;
	this.get = _TXLibHashtable_get;
	this.isEmpty = _TXLibHashtable_isEmpty;
	this.keys = _TXLibHashtable_keys;
	this.put = _TXLibHashtable_put;
	this.remove = _TXLibHashtable_remove;
	this.size = _TXLibHashtable_size;
	this.toString = _TXLibHashtable_toString;
	this.values = _TXLibHashtable_values;
	this.hashtable = new Array();
} //end TXLibHashtable Constructor

/* Private methods for internal use only */

/*
 * Clear the hashtable, make it contain no entry.
 */
function _TXLibHashtable_clear(){
	this.hashtable = new Array();
} //end _TXLibHashtable_clear

/*
 * Check if the hashtable contain a key.
 * Return: true/false
 */
function _TXLibHashtable_containsKey(key){
	var exists = false;
	for ( var i in this.hashtable ) {
		if ( i == key && this.hashtable[i] != null ) {
			exists = true;
			break;
		} //end if
	} //end for
	return exists;
} //end _TXLibHashtable_containsKey

/*
 * Check if the hashtable contain a value
 * Return: true/false
 */
function _TXLibHashtable_containsValue(value){
	var contains = false;
	if ( value != null ) {
		for ( var i in this.hashtable ) {
			if ( this.hashtable[i] == value ) {
				contains = true;
				break;
			} //end if
		} //end for
	} //end if
	return contains;
} //end _TXLibHashtable_containsValue

/**
 * Retrieve the value to which the specified key is mapped in this hashtable
 */
function _TXLibHashtable_get(key){
	return this.hashtable[key];
} //end _TXLibHashtable_get

/*
 * Check if the hashtable is empty.
 * Return: true/false
 */
function _TXLibHashtable_isEmpty(){
	return (parseInt(this.size()) == 0) ? true : false;
} //end _TXLibHashtable_isEmpty

/*
 * Retrieve array of keys the hashtable contains
 */
function _TXLibHashtable_keys(){
	var keys = new Array();
	for (var i in this.hashtable) {
		if (this.hashtable[i] != null)
			keys.push(i);
	} //end for
	return keys;
} //end _TXLibHashtable_keys

/*
 * Put a new entry into the hashtable.
 */
function _TXLibHashtable_put(key, value){
	if (key == null || value == null) {
		throw "NullPointerException {" + key + "},{" + value + "}";
	} else {
		this.hashtable[key] = value;
	} //end if
} //end _TXLibHashtable_put

/*
 * Remove an entry that is associated with a key.
 * Return: value of the removed entry.
 */
function _TXLibHashtable_remove(key){
	var rtn = this.hashtable[key];
	this.hashtable[key] = null;
	return rtn;
} //end _TXLibHashtable_remove

/*
 * Retrieve the hashtable's size (how many entries are there in the hashtable?)
 */
function _TXLibHashtable_size(){
	var size = 0;
	for ( var i in this.hashtable ) {
		if ( this.hashtable[i] != null )
			size++;
	} //end for
	return size;
} //end _TXLibHashtable_size

/*
 * Retrieve a string representation of the hashtable object in the form of a set
 * of entries, enclosed in braces and separated by the ASCII characters ", "
 * (comma and space).
 */
function _TXLibHashtable_toString() {
	var result = "";
	for ( var i in this.hashtable ) {     
		if (this.hashtable[i] != null)
			result += "{" + i + "},{" + this.hashtable[i] + "}\n";  
	} //end for
	return result;
} //end _TXLibHashtable_toString

/*
 * Retrieve array of values the hashtable contains
 */
function _TXLibHashtable_values() {
	var values = new Array();
	for ( var i in this.hashtable ) {
		if ( this.hashtable[i] != null )
			values.push(this.hashtable[i]);
    } //end for
	return values;
} //end _TXLibHashtable_values
/*********************************************************************
END Hashtable
*********************************************************************/
