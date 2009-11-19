          ////////////////////////////  Author's DavidNg
         // Vietnamese Keybooard ™ //
        //////////////////////////// ©2002-2006 VietOnLine®

      ///////////////////////////// vBulletin Board ///////
     // vbulletin_vks_detection //
    /////////////////////// Other Author's TrucLinh | Q.Nhu

  /////////////////////////////
 //  Access Keys
// Initilization
function getEL(id) { return document.getElementById(id) }
function getSF() { var sf=new Array(),x; for(x=0;x<skey.length;x++) sf[sf.length]=fcc(skey[x]); return sf }
function setMod(m) {
	if(m==-1) { engviet=0;if(getEL(toolbarid[4])) getEL(toolbarid[4]).checked=true }
	else { engviet=1;mod=m;if(getEL(toolbarid[m])) getEL(toolbarid[m]).checked=true }
	setSpell(dockspell);setOld(Old);updateInfo()
}
function setOld(box) {
	if(typeof(box)=="number") {
		Old=box;if(getEL(toolbarid[6])) getEL(toolbarid[6]).checked=box
	} else Old=(box.checked)?1:0
	updateInfo()
}
function setSpell(box) {
	if(typeof(box)=="number") { 
		spellerr=(box==1)?ckspell:nospell
		if(getEL(toolbarid[5])) getEL(toolbarid[5]).checked=box
	}
	else {
		if(box.checked) { spellerr=ckspell;dockspell=1 }
		else { spellerr=nospell;dockspell=0 }
	}
	updateInfo()
}
function onKeyDown(e) {
	if (e=='iframe') { frame=findF();var key=frame.event.keyCode }
	else var key=(!is_ie)?e.which:window.event.keyCode
	if((key==119)||(key==123)||(key==120)||(key==118)) {
		if(key==119) { engviet=1;setMod(((mod==3)?0:++mod)) }
		else if(key==118) { setOld(((Old==1)?0:1)) }
		else if(key==120) { dockspell=(dockspell==0)?1:0;setSpell(dockspell) }
		else if(key==123) {
			engviet=(engviet==0)?1:0
			if(engviet==0) setMod(-1)
			else setMod(mod)
		}
		updateInfo()
	}
}
function ifInit(w) {
	var sel=w.getSelection()
	range=sel?sel.getRangeAt(0):document.createRange()
}
function ifMoz(e) {
	var code=e.which,cwi=e.target.parentNode.wi
	if(typeof(cwi)=="undefined") cwi=e.target.parentNode.parentNode.wi
	if((e.ctrlKey)||((e.altKey)&&(code!=92)&&(code!=126))) return;ifInit(cwi)
	var node=range.endContainer,newPos;sk=fcc(code);saveStr=""
	if(checkCode(code)||(!range.startOffset)||(typeof(node.data)=='undefined')) return;node.sel=false
	if(node.data) {
		saveStr=node.data.substr(range.endOffset)
		if(range.startOffset!=range.endOffset) node.sel=true
		node.deleteData(range.startOffset,node.data.length)
	}
	range.setEnd(node,range.endOffset)
	range.setStart(node,0)
	if(!node.data) return
	node.value=node.data; node.pos=node.data.length; node.which=code
	start(node,e)
	node.insertData(node.data.length,saveStr)
	newPos=node.data.length-saveStr.length+kl
	range.setEnd(node,newPos);range.setStart(node,newPos);kl=0
	if(specialChange) { specialChange=false; changed=false; node.deleteData(node.pos-1,1) }
	if(changed) { changed=false; e.preventDefault() }
}
function FKeyPress() {
	var obj=findF()
	sk=fcc(obj.event.keyCode)
	if(checkCode(obj.event.keyCode)||((obj.event.ctrlKey)&&(obj.event.keyCode!=92)&&(obj.event.keyCode!=126))) return
	start(obj,fcc(obj.event.keyCode))
	if (changed) { changed=false; return false }
}
function checkCode(code) { if(((engviet==0)||((code<45)&&(code!=42)&&(code!=32)&&(code!=39)&&(code!=40)&&(code!=43))||(code==145)||(code==255))) return true; return false }
function fcc(x) { return String.fromCharCode(x) }
if(WebCookie==1) { setCookie=doSetCookie; getCookie=doGetCookie }
else { setCookie=noCookie; getCookie=noCookie }
function noCookie() {}
function doSetCookie() {
	var exp=new Date(11245711156480).toGMTString()
	document.cookie='engviet='+engviet+';expires='+exp
	document.cookie='mod='+mod+';expires='+exp
	document.cookie='ckspell='+dockspell+';expires='+exp
	document.cookie='old='+Old+';expires='+exp
}
function doGetCookie() {
	var ck=document.cookie, res=/mod/.test(ck)
	if((!res)||(ck.indexOf('ckspell')<0)) { setCookie(); return }
	var p,ckA=ck.split(';')
	for(var i=0;i<ckA.length;i++) {
		p=ckA[i].split('='); p[0]=p[0].replace(/^\s+/g,""); p[1]=parseInt(p[1])
		if(p[0]=='engviet') engviet=p[1]
		else if(p[0]=='mod') mod=p[1]
		else if(p[0]=='ckspell') {
			if(p[1]==0) { dockspell=0; spellerr=nospell }
			else { dockspell=1; spellerr=ckspell }
		} else if(p[0]=='old') Old=parseInt(p[1])
	}
}
if(!is_ie) {
	if(agt.indexOf("opera")>=0) {
		operaV=agt.split(" ");operaVersion=parseInt(operaV[operaV.length-1])
		if(operaVersion>=8) is_opera=true
		else {
			operaV=operaV[0].split("/");operaVersion=parseInt(operaV[1])
			if(operaVersion>=8) is_opera=true
		}
	} else if(agt.indexOf("khtml")>=0) isKHTML=true
	else {
		ver=agt.substr(agt.indexOf("rv:")+3)
		ver=parseFloat(ver.substr(0,ver.indexOf(" ")))
		if(agt.indexOf("mozilla")<0) ver=0
	}
}
function up(w) {
	w=w.toUpperCase()
	if(isKHTML) {
		str="êôơâăưếốớấắứềồờầằừễỗỡẫẵữệộợậặự",rep="ÊÔƠÂĂƯẾỐỚẤẮỨỀỒỜẦẰỪỄỖỠẪẴỮỆỘỢẶỰ"
		for(z=0;z<w.length;z++) {
			io=str.indexOf(w.substr(z,1))
			if(io>=0) w=w.substr(0,z)+rep.substr(io,1)+w.substr(z+1)
		}
	}
	return w
}
function findIgnore(el) {
	for(i=0;i<novks.length;i++) if((el.name==novks[i])&&(novks[i].length>0)) return true
}
if((is_ie)||(ver>=1.3)||(is_opera)||(isKHTML)) {
	getCookie()
	if(engviet==0) setMod(-1)
	else setMod(mod)
	setSpell(dockspell);setOld(Old);statusMessage()
} else support=false
function onKeyPress(e) {
	if(!support) return
	if(!is_ie) { var el=e.target,code=e.which; if(e.ctrlKey) return; if((e.altKey)&&(code!=92)&&(code!=126)) return }
	else { var el=window.event.srcElement,code=window.event.keyCode; if((event.ctrlKey)&&(code!=92)&&(code!=126)) return }
	if(((el.type!='textarea')&&(el.type!='text'))||checkCode(code)) return
	sk=fcc(code); if (findIgnore(el)) return
	if(!is_ie) start(el,e)
	else start(el,sk)
	if(changed) { 
		changed=false
		if (!is_ie) e.preventDefault()
		else return false
	}
}
function attachEvt(obj,evt,handle,capture) {
	if(is_ie) obj.attachEvent("on"+evt,handle)
	else obj.addEventListener(evt,handle,capture)
}
attachEvt(document,"keydown",onKeyDown,false)
attachEvt(document,"keypress",onKeyPress,false)
function findF() {
	for(g=0;g<fID.length;g++) {
		if(findIgnore(fID[g])) return;frame=document.frames[fID[g].id]
		if((typeof(frame)!="undefined")&&(frame.document)&&(frame.event)) return frame
	}
}
function onKeyDownI() { onKeyDown("iframe") }
function init() {
var vksk=false
if((support)&&(!isKHTML)) {
	if(is_opera) { if(operaVersion<9) return }
	for(g=0;g<fID.length;g++) {
		if(findIgnore(fID[g])) continue
		if(is_ie) {
			frame=document.frames[fID[g].id]
			if((typeof(frame)!="undefined")&&(frame.document)) doc=frame.document
			if((doc)&&(up(doc.designMode)=="ON")) {
				for(l=0;l<attached.length;l++) if(doc==attached[l]) { vksk=true; break }
				if(!vksk) {
					attached[attached.length]=doc
					attachEvt(doc,"keydown",onKeyDownI,false)
					attachEvt(doc,"keypress",FKeyPress,false)
				} else vksk=false
			}
		} else {
			wi=fID[g].contentWindow;iframedit=wi.document
			try { iframedit.wi=wi } catch(e) { }
			if(up(iframedit.designMode)=="ON") {
				attachEvt(iframedit,"keypress",ifMoz,false)
				attachEvt(iframedit,"keydown",onKeyDown,true)
			}
		}
	}
}
}
function vkst() { vks=50;while(vks<5000) {setTimeout("init()",vks);vks+=50} }
vkst();attachEvt(document,"mousedown",vkst,false)

  /////////////////////////////////
 // Basic detection 2002 - 2006 //
//  The End                    //