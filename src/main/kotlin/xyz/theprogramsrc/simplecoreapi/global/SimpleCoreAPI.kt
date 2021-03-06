package xyz.theprogramsrc.simplecoreapi.global

import xyz.theprogramsrc.simplecoreapi.global.module.ModuleManager
import xyz.theprogramsrc.simplecoreapi.global.utils.ILogger
import xyz.theprogramsrc.simplecoreapi.global.utils.SoftwareType
import xyz.theprogramsrc.simplecoreapi.global.utils.update.GitHubUpdateChecker
import java.util.*

/**
 * Class used to initialize SimpleCoreAPI (DO NOT CALL IT FROM EXTERNAL PLUGINS, IT MAY CRASH)
 * @param logger The logger to use
 */
class SimpleCoreAPI(logger: ILogger) {

    companion object {
        /**
         * Instance of SimpleCoreAPI. Use it to retrieve the module manager
         * @return The instance of SimpleCoreAPI
         */
        lateinit var instance: SimpleCoreAPI
            private set
    }

    /**
     * The Module Manager
     * @return The [ModuleManager]
     */
    val moduleManager: ModuleManager?

    /**
     * The [SoftwareType] type running on the server
     * @return The [SoftwareType] the server is running
     */
    val softwareType: SoftwareType

    init {
        instance = this

        logger.info("SimpleCoreAPI v${getVersion()} - Git Commit: ${getShortHash()}")
        if (getFullHash() != "unknown") {
            GitHubUpdateChecker(logger, "TheProgramSrc/SimpleCoreAPI", getVersion()).checkWithPrint()
        }

        softwareType = SoftwareType.values().firstOrNull { it.check() } ?: SoftwareType.UNKNOWN
        if(softwareType != SoftwareType.UNKNOWN && softwareType.display != null) {
            logger.info("Running API with software ${softwareType.display}")
        }
        moduleManager = ModuleManager.init(logger)
    }

    /**
     * Gets the short version of the commit hash
     * @return The short commit hash
     */
    fun getShortHash(): String = "@git_short@"

    /**
     * Gets the full version of the commit hash
     * @return The full commit hash
     */
    fun getFullHash(): String = "@git_full@"

    /**
     * Gets the version of SimpleCoreAPI
     * @return The version of SimpleCoreAPI
     */
    fun getVersion(): String = "@version@"

    /**
     * Checks if the current [SoftwareType] is the one specified
     * @param softwareType The [SoftwareType] to check
     * @return true if the current [SoftwareType] is the one specified
     */
    fun isRunningSoftwareType(softwareType: SoftwareType) = softwareType.check()
}