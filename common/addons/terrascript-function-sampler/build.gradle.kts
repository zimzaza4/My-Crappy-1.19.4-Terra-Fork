version = version("0.1.0")

dependencies {
    compileOnlyApi(project(":common:addons:manifest-addon-loader"))
    compileOnlyApi(project(":common:addons:config-noise-function"))
    compileOnlyApi(project(":common:addons:structure-terrascript-loader"))
}
