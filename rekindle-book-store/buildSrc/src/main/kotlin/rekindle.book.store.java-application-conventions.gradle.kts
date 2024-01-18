plugins {
    id("rekindle.book.store.java-common-conventions")
    application
    id("com.google.cloud.tools.jib") apply true
}

tasks.withType<Jar> {
    destinationDirectory = File("${projectDir.path}/build/lib")
}

jib {
    var tag = "latest"
    from {
        image = "amazoncorretto:21.0.1"
    }
    to {
        image = "rekindle/${project.name}"
        tags = setOf(tag) as MutableSet<String>
    }
}