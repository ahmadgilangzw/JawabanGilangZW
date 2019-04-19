# JawabanGilangZW
Jawaban Ahmad Gilang Zain Wahabi

Info

Jawaban A. java_basic
======================================
- Menggunakan Java 8
- Terdapat jawaban bagian "a" dan "b"


Jawaban B. java_intermediate
======================================
- Menggunakan Java 8
- Spring Boot
- Maven
- Database Postgres
--------------------------------------
Petunjuk Penggunaan
- Jalankan script di dalam file script_generate_db_java_intermediate.sql

- Kemudian insert data-data file csv kedalam database postgres dengan cara : 
	- masuk ke folder "2,3. insertDataApps"
	- jika menggunakan windows tinggal double klik saja file Start.bat
	- jika menggunakan linux atau mac silahkan jalankan file jar berikut "insert-data-apps-0.0.1-SNAPSHOT.jar"
	- proses ini akan memasukan data-data didalam file csv di folder /data/ ke dalam database postgres

- Kemudian silahkan execute script sql didalam file "4. Query SQL.sql"

- Kemudian silahkan jalankan aplikasi di dalam folder "5.BackEndWebOrder" untuk menjalankan aplikasi backend nya
	- masuk ke folder "5.BackEndWebOrder"
	- jika menggunakan windows tinggal double klik saja file Start.bat
	- jika menggunakan linux atau mac silahkan jalankan file jar berikut "backend-weborder-0.0.1-SNAPSHOT.jar"
	- proses ini akan menjalankan aplikasi backend nya

- Kemudian silahkan jalankan aplikasi di dalam folder "5.FrontEndOrderApps" untuk menjalankan aplikasi frontend nya
	- masuk ke folder "5.FrontEndOrderApps"
	- jika menggunakan windows tinggal double klik saja file Start.bat
	- jika menggunakan linux atau mac silahkan jalankan file jar berikut "FrontEndOrderApps.jar" didalam folder "dist"
	- proses ini akan menjalankan aplikasi frontend nya
	
NOTE: aplikasi frontend tidak akan jalan jika aplikasi backend nya tidak dijalankan terlebih dahulu.


Jawaban C. java_senior
======================================
- Menggunakan Java 8
- Spring Boot
- Maven
- Database MongoDb
--------------------------------------
Petunjuk Penggunaan
- Silahkan buat database di mongodb dan beberapa collection seperti dibawah ini.
	- Nama Database : java-intermediate
	- Collections :
			- create collection customers
			- create collection employees
			- create collection products
			- create collection shipping_methods
			- create collection orders
			- create collection order_details

- Kemudian insert data-data file csv ke database mongodb dengan cara : 
	- masuk ke folder "2.insertSpringMongoDb"
	- jika menggunakan windows tinggal double klik saja file Start.bat
	- jika menggunakan linux atau mac silahkan jalankan file jar berikut "insert-mongodb-0.0.1-SNAPSHOT.jar"
	- proses ini akan memasukan data-data didalam file csv di folder /data/ ke dalam database mongodb

- Kemudian silahkan jalankan aplikasi didalam folder "3.engineWebOrder-mongodb" untuk menjalankan aplikasi backend nya
	- masuk ke folder "3.engineWebOrder-mongodb"
	- jika menggunakan windows tinggal double klik saja file Start.bat
	- jika menggunakan linux atau mac silahkan jalankan file jar berikut "engine-web-order-mongodb-0.0.1-SNAPSHOT.jar"
	- proses ini akan menjalankan aplikasi backend nya
	
- Kemudian silahkan jalankan aplikasi didalam folder "3.FrontendWebOrder" untuk menjalankan aplikasi frontend nya
	- masuk ke folder "3.FrontendWebOrder"
	- jika menggunakan windows tinggal double klik saja file Start.bat
	- jika menggunakan linux atau mac silahkan jalankan file jar berikut "FrontendWebOrder.jar" didalam folder "dist"
	- proses ini akan menjalankan aplikasi frontend nya
	
- Sekian Terimakasih
