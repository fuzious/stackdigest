//for adding question
$(document).ready(function(){

	var arr = null;
	$.ajax({
		url: "/feedData/java",
		type: "GET",
		success: function (data) {
			arr=data;
			console.log(JSON.stringify(arr));
		},error: function (jqXHR,textStatus,errorThrown) {
			alert(jqXHR+" "+textStatus+" "+errorThrown)
		},
		complete: function () {
			document.getElementById("add-button").onclick = function(){
				location.href = "question.html";
			};




// Test Data
// Array of 10 objects









//ON- CLICK function for upvoting dynamically
// let count = 0;
// function up(){
// 	if(count%2===0)
// 	document.getElementById("upvote").style.borderBottomColor = "green";
// 	else
// 	document.getElementById("upvote").style.borderBottomColor = "gray";
// 	count++;
// }


			var img_obj = document.querySelectorAll(".avatar");
			var info_obj = document.querySelectorAll(".info");
			var ques_obj = document.querySelectorAll(".ques");
			var ans_obj = document.querySelectorAll(".ans");
			var upvote_obj = document.querySelectorAll(".number");



			img_obj.forEach(function(element,index){
				element.src= arr[index].profileImage;
			});

			info_obj.forEach(function(element,index){
				element.innerHTML = arr[index].displayName;
			});

			ques_obj.forEach(function(element,index){
				element.innerHTML = arr[index].title;
			});

			ans_obj.forEach(function(element,index){
				element.innerHTML = arr[index].answersD.body;
			});
			upvote_obj.forEach(function(element,index){
				element.innerHTML = arr[index].score;
			});


		}
	})




});





