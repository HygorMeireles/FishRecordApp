package br.com.fishrecord.impl.ui.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.fishrecord.impl.data.datasource.model.User
import br.com.fishrecord.theme.components.loading.provider.LocalLoadingDialog
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun LoginScreen(
    navigateToHome: (User) -> Unit
) {
    val loginViewModel = koinViewModel<LoginViewModel>()
    val loginViewState by loginViewModel.loginState.collectAsStateWithLifecycle()
    val loadingDialog = LocalLoadingDialog.current

    // TODO cria o content
//    LoginContent(
//        viewState = loginViewState,
//        loadingDialogManager = loadingDialog,
//        doLogin = {email, password ->
//            loginViewModel.login(email, password)
//        },
//        navigateToHome = navigateToHome
//    )
}