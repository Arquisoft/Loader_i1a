# Loader_i1a

[![Build Status](https://travis-ci.org/Arquisoft/Loader_i1a.svg?branch=master)](https://travis-ci.org/Arquisoft/Loader_i1a)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/d2f21516131c4cb2b1c1b5bd48eb60a4)](https://www.codacy.com/app/jelabra/Loader_i1a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/Loader_i1a&amp;utm_campaign=Badge_Grade)
[![codecov](https://codecov.io/gh/Arquisoft/Loader_i1a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/Loader_i1a)

Skeleton of Agents Loader module

# Setup
Before start using the project, is necessary to define the services that will take part in the management of the database.

## mLab
We are using an instance of **MongoDB** in **mLab**, that is a fully managed cloud database service. We are using this service because it is very helpful for us to have the database in a server, and not to have it in local. However, it is very advisable to know how to initialize the database in local through MongoDB. Because of that, below there is information about MongoDB.

## MongoDB
In order to run the application you need to download and install [mongoDB](https://www.mongodb.com/dr/fastdl.mongodb.org/win32/mongodb-win32-x86_64-2008plus-ssl-3.4.2-signed.msi/download).

Below is detailed how to install MongoDB on three different operating systems. **Windows**, **Ubuntu(Linux)** and **MacOS**.

### Windows
#### Installing MongoDB on Windows
Once we have downloaded the latest version of MongoDB we proceed to its installation. The first step is to extract the downloaded file. For that, open the command window and run the next command.
```
C:\>move mongodb-win64-* mongodb
```
MongoDB requires a data folder to store its files, so the next step will be to create that folder. Its default location is C:, so yo need to run the following sequence of commands to do that:
```
C:\>md data
C:\md data\db
```
If you want to install MongoDB at a different location, you will have to set the path **dbpath** in the file **mongo.exe**. For that task, let's suppese that the installation folder is D:\set up\mongodb. The next step is to issue the following commands:
```
  C:\Users\XYZ>d:
  D:\>cd "set up"
  D:\set up>cd mongodb
  D:\set up\mongodb>cd bin
  D:\set up\mongodb\bin>mongod.exe --dbpath "d:\set up\mongodb\data" 
```
This will show the message *waiting for connections*, which indicates that the mongod.exe process is running successfully.

#### Running MongoDB on Windows
Now, you have to open a new command prompt and run the following command.
```
D:\set up\mongodb\bin>mongo.exe
MongoDB shell version: 2.4.6
connecting to: test
>db.test.save( { a: 1 } )
>db.test.find()
{ "_id" : ObjectId(5879b0f65a56a454), "a" : 1 }
>
```
This will show that MongoDB is installed and run successfully. Next time when you run MongoDB, you need to issue only commands.

```
D:\set up\mongodb\bin>mongod.exe --dbpath "d:\set up\mongodb\data"
D:\set up\mongodb\bin>mongo.exe
```

### Ubuntu
#### Installing MongoDB on Ubuntu
The first step to install MongoDB on Ubunto is to issue the following command to import the MongoDB public GPG key.
```
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 7F0CEB10
```
Then, you will have to run another command to create a /etc/apt/sources.list.d/mongodb.list file
```
echo 'deb http://downloads-distro.mongodb.org/repo/ubuntu-upstart dist 10gen' 
   | sudo tee /etc/apt/sources.list.d/mongodb.list
```
Now, enter the following command to update the repository
```
sudo apt-get update
```
The next step is to install MongoDB.
```
apt-get install mongodb-10gen = 2.2.3
```
Now MongoDB has been installed succesfully.

#### Running MongoDB on Ubuntu
For **starting** MongoDB, you have to enter the following command.
```
sudo service mongodb start
```
In the case you want to **stop** MongoDB issue the command below.
```
sudo service mongodb stop
```
To restart it, enter the next command.
```
sudo service mongodb restart
```
Finally, to use MongoDB run the following command.
```
mongo
```

### MacOS
#### Installing MongoDB on MacOS
The first step to install MongoDB on MacOS is to extract the files of the downloaded archive. To do that, you have to introduce the following command from the system shell.
```
tar -zxvf mongodb-osx-ssl-x86_64-3.6.2.tgz
```
Next, you will have to copy the extracted archive to the target directory, by running the next sequence of commands.
```
mkdir -p mongodb
cp -R -n mongodb-osx-ssl-x86_64-3.6.2/ mongodb
```
The last step will be to ensure the location of the binaries is in the **PATH** variable. The MongoDB binaries are in the bin/ directory of the archive. To ensure that the binaries are in your **PATH**, you can modify your **PATH**.
For example, you can add the following line to your shell’s rc file.
```
export PATH=<mongodb-install-directory>/bin:$PATH
```
Replace **<mongodb-install-directory>** with the path to the extracted MongoDB archive.

#### Running MongoDB on MacOS
First of all, you have to create the data directory for MongoDB to store its files.
```
mkdir -p /data/db
```
**_NOTE: Before running mongod for the first time, ensure that the user account running mongod has read and write permissions for the directory._**

The next step to run MongoDB is to enter the following command if your system **PATH** variable includes the location of the mongod binary and if you use the default data directory.
```
mongod
```
If your **PATH** does not include the location of the mongod binary, enter the full path to the mongod binary at the system prompt.
```
<path to binary>/mongod
```
If you do not use the default data directory (i.e., /data/db), specify the path to the data directory using the **--dbpath** option.
```
mongod --dbpath <path to data directory>
```
Finally, start a mongo shell on the same host machine as the mongod. Use the --host command line option to specify the localhost address and port that the mongod listens on.
```
mongo --host 127.0.0.1:27017
```
To stop MongoDB press **Control+C** the following command on the prompt shell.

### Help in MongoDB
To get a list of commands, type **db.help()** in MongoDB client. This will give you a list of commands.

### MongoDB statistics
To get stats about MongoDB server, type the command **db.stats()** in MongoDB client. This will show the database name, number of collection and documents in the database.

## Team members
- [Pedro Blanco Suárez (UO251935)](https://github.com/pedrytus)  
- [David Ferreiro Fernández (UO250757)](https://github.com/rimorD)  
- [Manuel García Fernández (UO250979)](https://github.com/faltosu)  
- [Jorge González-Nuevo Bueno (UO251166)](https://github.com/jorgegnb)
- [Roberto Pérez Sánchez (UO250973)](https://github.com/robertops18) 

# Last year authors

* Gonzalo de la Cruz Fernández (UO244583)
* Oriol Invernón Llaneza (UO245303)
* Adrian Mirón Cao (UO244843)
