# DoctorsDiary

We are trying to use Realm Db , Epresso test, JUnit test and trying to follow solid design principle with new software architectue like human body.

## Realm Database
- Configuration and Setup
- CRUD
- Migration
- Export

## Architecture Design
- Custome (Thinking Something New)

## Unit Test
- JUnit
- Espresso

#### Realm Database

Realm is a cross-platform mobile database solution designed specifically for mobile applications. It's fast, lightweight, and extremely simple to integrate in your project. Most common functions such as querying the database consist of a single line of code!

**Configuration and Setup**

Actually Realm configuration and setup is very very easy. 
just add this line to your project level gradle file

```java
 buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.2.3'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        // For realm Database
        classpath "io.realm:realm-gradle-plugin:2.0.2"
    }
}
```
and add this line to your app level gradle file... 

```java
apply plugin: 'realm-android'
```
Thats it............ very simple

**CRUD**

- Save & Update

For Save and Update we are using this single method 
```java
public static void saveDataToRealm(Context context, final RealmObject obj, final Class<RealmObject> clazz) {
        try {
            Realm.init(context);

            Realm realm = Realm.getDefaultInstance();
            realm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    //RealmObject planForMonth = realm.createObject(clazz);
                    // realm.copyToRealm(obj);
                    realm.copyToRealmOrUpdate(obj);
                }
            }, new Realm.Transaction.OnSuccess() {
                @Override
                public void onSuccess() {
                    // Transaction was a success.
                    Log.e(App.ACTION_MSG, "Data Save Successfully");
                    //returnType =true;
                }
            }, new Realm.Transaction.OnError() {
                @Override
                public void onError(Throwable error) {
                    // Transaction failed and was automatically canceled.
                    Log.e(App.ACTION_MSG, "Data Save Failed !!: "+error.getMessage());
                }
            });

        }catch(Exception ex){
            Log.e("Error",ex.getMessage());
        }
    }
```
and this is our Realm Object 

```java
public class Comments extends RealmObject implements Serializable,Comparable{

    @PrimaryKey
    private String date;

    private String personsName;
    private String comment;
    private String updateDate;
    private int year;
    private int month;
    private int day;
    
    // setter and getter 

```
based on @PrimaryKey realm will automatically update existing data if it matches any existing data otherwise realm will insert that data as new record. So using this single method all kind of save and update through the application will be managed.

- Read 

We are using this method for data retrive from Realm database

```java
public static RealmResults getTotalOneMonthReport(Context context,final Class<RealmObject> clazz,int year, int month){

        Realm.init(context);
        Realm realm =Realm.getDefaultInstance();
        RealmQuery<RealmObject> query = realm.where(clazz);
        query.equalTo("year",year);
        query.equalTo("month",month);
        query.equalTo("hasReport",true);
        RealmResults<RealmObject> result = query.findAll();

        return result;
    }
```

RealmResults is the list of expected object. we can read it using loop.

**Migration** In Progress

**Export**

### Architecture Design

**Clean**

**MVP**

**Custome (Thinking Something New)**


### Unit Test

**JUnit**

**Espresso**







