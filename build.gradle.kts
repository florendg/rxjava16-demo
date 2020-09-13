plugins {
  java
  application
}



repositories {
  mavenCentral()
}

dependencies {
  implementation("io.reactivex.rxjava3:rxjava:3.0.6")
}

tasks {
  test{
    useJUnitPlatform()
  }

  application  {
    mainClass.set("com.weirdduke.rxjava16.DemoJava16Scheduler")
  }

  withType<JavaCompile>() {
    version = JavaVersion.VERSION_16
  }
}