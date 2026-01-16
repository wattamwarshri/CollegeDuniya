# # Project College-Duniya

## To Access the swagger UI:
Without SSL
```
http://localhost:8081/swagger-ui/index.html
```
With SSL
```
https://localhost:8081/swagger-ui/index.html
```

***

## Install collegeduniya package on ubuntu( .deb package)
```
 sudo dpkg -i collegeduniya_12.1.0_all.deb
 sudo dpkg --remove collegeduniya (Uninstalling the package)-- This will uninstall all the directories and files created during installation
```
***

## Install collegeduniya package on centOS( .rpm package)
```
 sudo yum install collegeduniya_1.0.0_all.rpm
 sudo yum --remove collegeduniya (Uninstalling the package)-- This will uninstall all the directories and files created during installation
```
***


## DB commands
```
Step-1: create database collegeduniya
Step-2: execute application
Step-3: insert into clothes(brand_name,cloth_name,price,quantity,size) values("Adidas","Pant",999,5,"M");
        insert into clothes(brand_name,cloth_name,price,quantity,size) values("PUMA","T-Shirt",499,10,"XL");


```

## Add below in config of IDE to implement custom logger in project
```
-Dlogging.config=/home/shri-wattamwar/IdeaProjects/CollegeDuniya/CollegeDuniya/Backend/CollegeDuniya/conf/logback.xml
```
## Command to generate ssl cert
```agsl
keytool -genkey -alias shri-https-key -storetype JKS -keyalg RSA -keysize 2048 -validity 365 -keystore dmartkeystore.jks
```
## Name
College-Duniya

## Description
Personal Project developed by ShRi

## Developement & Implementation
- Added .deb package creation in the project(To install on ubuntu OS) [Debian]
- Added .rpm package creation in the project(To install on centos OS)[RHEL]

Below is remaining
- Added logger
- Added JPA methods
- Added DAO methods
- Added Pagination
- Added REST-> REST Communication(REST-Client --> REST-Controller)
- Added SSL Setup
- Added Interceptor in the project
- Kafka-Integration (For now, create kafka topic manually, then use kafka integration)


## Contributing
- Shri

## Authors and acknowledgment
Mr. Shrinivas Wattamwar


## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://git.gurucul.com/shrinivas.wattamwar/dmart.git
git branch -M main
git push -uf origin main
```
