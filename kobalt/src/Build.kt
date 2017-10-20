import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.publish.bintray

val dev = false
val kobaltDep = if(dev) "kobalt" else "kobalt-plugin-api"

val bs = buildScript {
    repos("http://dl.bintray.com/cbeust/maven/")

}

val project = project {
    name = "kobalt-antlr"
    group = "com.beust"
    artifactId = name
    version = "0.4"

    dependencies {
        compile("com.beust:$kobaltDep:1.0.68",
                "org.antlr:antlr4:4.7")
    }

    assemble {
        mavenJars {
            fatJar = true
        }
    }

    bintray {
        publish = true
    }

}

