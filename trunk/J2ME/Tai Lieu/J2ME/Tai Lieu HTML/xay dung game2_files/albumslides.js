function startAnimation(){
	animateImagesIn('albumslides');
}
var element1, element2, currentImage = -1, imgList, value = 0;
function animateImagesIn(elementId){
	var element = document.getElementById(elementId);
	imgList = element.getElementsByTagName("img");	
	for(var i=0;i<imgList.length;i++)
		imgList[i].parentNode.style.display = "none";
	currentImage = i-1;
	startTransition();
}
function startTransition(){
	if(currentImage>=imgList.length) currentImage = 0;
	element1 = (element2)?element2:imgList[currentImage].parentNode;
	element2 = (imgList[++currentImage])?imgList[currentImage].parentNode:imgList[currentImage = 0].parentNode;
	element1.style.display = "block";
	element2.style.display = "block";
	value = 1;
	fader();
}
function fader(){
	value = value - 0.05;
	value = parseInt(value*100)/100;
	element1.style.opacity = value;
	element2.style.opacity = (1-value);
	element1.style.filter = "alpha(opacity="+(value*100)+")";
	element2.style.filter = "alpha(opacity="+(100-(value*100))+")";
	if(value>0 && value<1){
		window.setTimeout(fader, 100);
	} else {
		element1.style.display = "none";
		window.setTimeout(startTransition, 2600);
	}
}
