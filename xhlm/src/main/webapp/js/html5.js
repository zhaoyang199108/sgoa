(function (a, b) {  
function h(a, b) {  
var c = a.createElement_x("p"),  
d = a.getElementsByTagName_r("head")[0] || a.documentElement;  
return c.innerHTML = "x<style>" + b + "</style>",  
d.insertBefore(c.lastChild, d.firstChild)  
}  
function i() {  
var a = l.elements;  
returntypeof a == "string" ? a.split(" ") : a  
}  
function j(a) {  
var b = {},  
c = a.createElement_x,  
f = a.createDocumentFragment,  
g = f();  
a.createElement_x = function (a) {  
if (!l.shivMethods)  
return c(a);  
var f;  
return b[a] ? f = b[a].cloneNode() : e.test(a) ? f = (b[a] = c(a)).cloneNode() : f = c(a),  
f.canHaveChildren && !d.test(a) ? g.a(f) : f  
},  
a.createDocumentFragment = Function("h,f", "return function(){var n=f.cloneNode(),c=n.createElement_x;h.shivMethods&&(" + i().join().replace(/\w+/g, function (a) {  
return c(a),  
g.createElement_x(a),  
'c("' + a + '")'  
}) + ");return n}")(l, g)  
}  
function k(a) {  
var b;  
return a.documentShived ? a : (l.shivCSS && !f && (b = !!h(a, "article,aside,details,figcaption,figure,footer,header,hgroup,nav,section{display:block}audio{display:none}canvas,video{display:inline-block;*display:inline;*zoom:1}[hidden]{display:none}audio[controls]{display:inline-block;*display:inline;*zoom:1}mark{background:#FF0;color:#000}")), g || (b = !j(a)), b && (a.documentShived = b), a)  
}  
var c = a.html5 || {},  
d = /^<|^(?:button|form|map|select|textarea|object|iframe|option|optgroup)$/i,  
e = /^<|^(?:a|b|button|code|div|fieldset|form|h1|h2|h3|h4|h5|h6|i|iframe|img|input|label|li|link|ol|option|p|param|q|script|select|span|strong|style|table|tbody|td|textarea|tfoot|th|thead|tr|ul)$/i,  
f,  
g;  
(function () {  
var c = b.createElement_x("a");  
c.innerHTML = "<xyz></xyz>",  
f = "hidden"in c,  
f && typeof injectElementWithStyles == "function" && injectElementWithStyles("#modernizr{}", function (b) {  
b.hidden = !0,  
f = (a.getComputedStyle ? getComputedStyle(b, null) : b.currentStyle).display == "none"  
}),  
g = c.childNodes.length == 1 || function () {  
try {  
b.createElement_x("a")  
} catch (a) {  
return !0  
}  
var c = b.createDocumentFragment();  
returntypeof c.cloneNode == "undefined" || typeof c.createDocumentFragment == "undefined" || typeof c.createElement_x == "undefined"  
}  
()  
})();  
var l = {  
elements : c.elements || "abbr article aside audio bdi canvas data datalist details figcaption figure footer header hgroup mark meter nav output progress section summary time video",  
shivCSS : c.shivCSS !== !1,  
shivMethods : c.shivMethods !== !1,  
type : "default",  
shivDocument : k  
};  
a.html5 = l,  
k(b)  
})(this, document)