package br.com.fishrecord

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fishrecord.common.toastprovider.LocalToasterDialog
import br.com.fishrecord.impl.di.appModule
import br.com.fishrecord.impl.ui.login.LoginScreen
import br.com.fishrecord.impl.ui.splash.SplashScreen
import br.com.fishrecord.theme.components.loading.component.LoadingDialogComponent
import br.com.fishrecord.theme.components.loading.provider.LocalLoadingDialog
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.setSingletonImageLoaderFactory
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger
import com.dokar.sonner.Toaster
import kotlinx.serialization.Serializable
import org.koin.compose.KoinApplication
import okio.FileSystem


@Serializable
object Splash

@Serializable
object Login

@Composable
fun App() {
    val loadingManager = LocalLoadingDialog.current
    val toasterState = LocalToasterDialog.current

    KoinApplication(application = {
        modules(listOf(appModule))
    }) {
        MaterialTheme {

            setSingletonImageLoaderFactory { context ->
                getAsyncImageLoader(context)
            }

            val navController = rememberNavController()
            LoadingDialogComponent(loadingManager)
            Toaster(state = toasterState)
            NavHost(navController, startDestination = Splash) {
                composable<Splash> { backStackEntry ->
                    SplashScreen() {
                        navController.navigate(route = Login)
                    }
                }
                composable<Login> {
                    LoginScreen {
                        // TODO navegar para a tela principal
                    }
                }
            }
        }
    }
}

fun getAsyncImageLoader(context: PlatformContext) =
    ImageLoader.Builder(context).memoryCachePolicy(CachePolicy.ENABLED).memoryCache {
        MemoryCache.Builder().maxSizePercent(context, 0.3).strongReferencesEnabled(true).build()
    }.diskCachePolicy(CachePolicy.ENABLED).networkCachePolicy(CachePolicy.ENABLED).diskCache {
        newDiskCache()
    }.crossfade(true).logger(DebugLogger()).build()

fun newDiskCache(): DiskCache {
    return DiskCache.Builder().directory(FileSystem.SYSTEM_TEMPORARY_DIRECTORY / "image_cache")
        .maxSizeBytes(1024L * 1024 * 1024) // 512MB
        .build()
}
