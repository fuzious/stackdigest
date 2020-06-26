//for adding question


var arr = null;
var loginObject=null;

function construct() {
	var img_obj = document.querySelectorAll(".avatar");
	var info_obj = document.querySelectorAll(".info");
	var ques_obj = document.querySelectorAll(".ques");
	var ans_obj = document.querySelectorAll(".ans");
	var upvote_obj = document.querySelectorAll(".number");
	var ques_body = document.querySelectorAll(".qbody");



	img_obj.forEach(function(element,index){
		element.src= arr[index].profileImage;
	});

	info_obj.forEach(function(element,index){
		element.innerHTML = arr[index].displayName;
	});

	ques_obj.forEach(function(element,index){
		element.innerHTML = arr[index].title;
	});

	ques_body.forEach(function(element,index){
		element.innerHTML = arr[index].body;
	});

	ans_obj.forEach(function(element,index){
		element.innerHTML = arr[index].answersD.body;
		//var temp = element.innerHTML;
		// if(temp.length>100){
		// 	var str = temp.substring(0,101);
		// 	element.innerHTML = str;
		// 	var btn = document.createElement("button");
		// 	btn.innerHTML = "Read more";
		// 	btn.onclick = function(){
		// 		var temp2 = arr[index].answersD.body;
		// 		element.innerHTML = temp2;
		// 	}
		// }
	});
	upvote_obj.forEach(function(element,index){
		element.innerHTML = arr[index].score;
	});





//answer date code copied from stack overflow
	var ans_date = document.querySelectorAll(".answer-date");

	ans_date.forEach(function(element,index){
		var unixtime = arr[index].answersD.creationDate;
		function unixTime(unixtime) {

			var u = new Date(unixtime*1000);

			return u.getUTCFullYear() +
				'-' + ('0' + u.getUTCMonth()).slice(-2) +
				'-' + ('0' + u.getUTCDate()).slice(-2) +
				' ' + ('0' + u.getUTCHours()).slice(-2) +
				':' + ('0' + u.getUTCMinutes()).slice(-2) +
				':' + ('0' + u.getUTCSeconds()).slice(-2) +
				'.' + (u.getUTCMilliseconds() / 1000).toFixed(3).slice(2, 5)
		};
		element.innerHTML = "Answered on " + unixTime(unixtime);
	});



//USER-LOGIN-DATA
// 					var loginObject = {
// 						"displayname": "fuzious",
// 						"profileimage": "https://lh5.googleusercontent.com/-M_CiRPA16wk/AAAAAAAAAAI/AAAAAAAAAGE/bCMsny8ymA8/photo.jpg?sz=128",
// 						"userlink": "https://stackoverflow.com/users/6118183/fuzious"
// 					};

//USER-LOGIN-JS
	document.getElementById("account-photo").src = loginObject.profileimage;
	document.getElementById("login-name").innerHTML = loginObject.displayname;
	document.getElementById("profile-link").onclick = function(){
		location = loginObject.userlink;
	}
	document.getElementById("profile-link-2").onclick = function(){
		location = loginObject.userlink;
	}

//Storing form content in object
}

$(document).ready(function(){

	$.ajax({
		url: "/feedData/all",
		type: "GET",
		success: function (data) {
			arr = data;
			console.log(JSON.stringify(arr));
		}, error: function (jqXHR, textStatus, errorThrown) {
			alert(jqXHR + " " + textStatus + " " + errorThrown+" outer AJAX")
		},
		complete: function () {
			$.ajax({
				url: "/user",
				type: "GET",
				success: function (data) {
					loginObject=data;
				},
				error: function (jqXHR,textStatus,errorThrown) {
					alert(jqXHR+" "+textStatus+" "+errorThrown+" innet AJAX")
				},
				complete: construct
			})
		}
	})
});

function search() {
	console.log(document.getElementById("datas").value);
	requestUrl=document.getElementById("datas").value;
	$.ajax({
		type:"GET",
		url:"/feedData/"+requestUrl,
		success:function (data) {
			arr=data;
		},
		error: function (jqXHR,textStatus,errorThrown) {
			alert(jqXHR+" "+textStatus+" "+errorThrown+" inner AJAX")
		},
		complete: construct

	})

}




