
# Stack Digest

# Project Live <a href="stackdigest.herokuapp.com">here</a>
# Read about project here <a href="stackdigest.herokuapp.com/about">here</a>

# <span style="font-size: xx-large;">What is stackdigest?</span> 

<span style="font-size: large;">Stackdigest is a webapp to implement quora like features for stackoverflow which will help in growth of user's knowledge. It constructs a feed which has commonly asked/trending questions on stackoverflow. Through this user can get through most common problems of computer programming and avoid them which would save user's time too.</span>

# <span style="font-size: xx-large;">Why stackdigest?</span>

https://dev.to/stackoverflow/select-post-from-stack-overflow-questions-where-topic-git-order-by-votes-desc-id1

<span style="font-size: large;">For instance take the above article, how the writer has explained that most popular questions on stackoverflow are related to simple problems.  So on this analysis stackdigest shows most popular /trending so that the user does not waste his time over common issues.</span>

# What is 'my space' and 'all space' ?

<span style="font-size: large; color: #ff0000;">My space</span> <span style="font-size: large;">shows the user articles related to his interests which are taken from his stackoverflow active 'tags' like each user can see  his active tags from his stackoverflow's profile section like:</span>

<span style="font-size: large; color: #ff0000;">All space <span style="font-size: large; color: #000000;">shows the user all popular articles irrespective of his interests.</span></span>

<h1 id="Setup">How to Setup locally?</h1>
                <p><span style="font-size: large;">Clone the repo then either import the database using stackdigest.sql from repository or create database named 'stackdigest.sql' and provide credentials in files: hibernate.cfg.xml and application.properties and then run <code>mvn install</code> and <code>mvn spring-boot:run</code> then uncomment @Scheduled from StackDigestApplication.java for automated insertion </span></p>

# Tech Stack

*   <span style="font-size: large; color: #ff0000;">MySQL</span> has been used as **database**. Search **indexing** as BTree has been done for optimisation and **BCNF** **normalisation** has been done.
*   <span style="font-size: large; color: #ff0000;">EH-Cache</span> has been used for **in-memory database** optimisation to make user's interaction with the site faster.
*   <span style="font-size: large; color: #ff0000;">Spring-Boot</span> Used to fetch REST content from stackoverflow's API and build a webapp for stackdigest.
*   <span style="font-size: large; color: #ff0000;">Spring Security with JPA</span> Used to handle security features and OAuth of Stackdigest.
*   <span style="font-size: large; color: #ff0000;">Hibernate</span> Hibernate has been used as **ORM** for interactions with MySQL.
*   <span style="font-size: large; color: #ff0000;">Thymeleaf</span> template engine has been used for serving HTML content.

![Screenshot](ER Stackdigest.png)

##Backend by: 
<a href="https://github.com/fuzious">Arpit Srivastava</a>
##Frontend by:
<a href="https://github.com/">Sudhanshu Mishra</a>


<div id="footer">MIT Licence</div>

