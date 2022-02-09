# wildlife-tracker
wilflife tracker  is an app that allows rangers  to record sighting  of wild animals. near douglas fir .
the app allows rangers to  enter their details, then create  locations animals  and sightings.the rangers can then view the sighting of the animas made by  them and other ranger on various locations.

## Author 
Felix maina

## Setup and installation
<ul>
<li>java 11</li>
<li>Install intellij Idea</li>
<li>setup postgres  in the machine</li>
<li>clone this repo this repo via terminal</li>
<li>open the project</li>
</ul>

## Database setup requirements
<li>Navigate to the terminal</li>
<li>Type psql to open the database</li>
<li>CREATE DATABASE wildlife_tracker;</li>
<li>\c wildlife_tracker</li>
<li>CREATE TABLE animals (id serial PRIMARY KEY, name varchar,type VARCHAR,health VARCHAR,age VARCHAR);</li>
<li>CREATE TABLE locations (id serial PRIMARY KEY,name VARCHAR);</li>
<li>CREATE TABLE locations_sightings (id serial PRIMARY KEY,location_id INT,sighting_id INT);</li>
<li>CREATE TABLE rangers (id serial PRIMARY KEY,name VARCHAR,badge_number VARCHAR);</li>
<li>CREATE TABLE rangers_sightings (id serial PRIMARY KEY,ranger_id INT,sighting_id INT);</li>
<li>CREATE TABLE sightings (id serial PRIMARY KEY,animal_id INT,ranger_id INT,location_id INT,time TIMESTAMP);</li>
<li>CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;</li>
<li>Alternative navigate to the terminal and type psql<create.sql, it atomatically sets the database </li>

## for local execution 
<li>in the class named DB , add your Postgress name and Password</li>
<li>In the test class, change the name and the password </li>

## technologies used
<ul>
<li>Java 11 -for setting the models</li>
<li>Gradle for dependencies</li>
<li>Heroku- for deployment</li>
<li>Postgress for setting the database</li>
<li>Handlebars for displaying the views in the app</li>
</ul>

## BDD
<ol>
<li>Use this link to access</li>
<li>Click on create  ranger</li>
<li>Click on create to record the sighting of the animal</li>
<li>Click on locations to record the location of the animal observed</li>
<li>Click on create sighting where you fill the Animal, location and the ranger</li>
</li>click on view to see the rangers, the locations, the animals and the sightings made</li>
</ol>

## Support and contributions
For any contributions  regarding this projects feel free to reach me via email: karanifelix369@gmail.com.

### License

MIT License

Copyright (c) 2022 Felix Maina

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


 











