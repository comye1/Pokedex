# Pokedex

# Compose Navigation *with arguments*
```
1. NavHostController
val navController = rememberNavController()

2. NavHost
NavHost(
    navController = navController,
    startDestination = "pokemen_list_screen"
) {
    2-1. NavGraphBuilder - destination composables 의 route와 arguments들을 정의
    composable("pokemon_list_screen") {

    }
    composable("pokemon_detail_screen/{dominantColor}/{pokemonName}", //route에 arguments 포함
        arguments = listOf(
            navArgument("dominantColor") { 
                // NavArgumentBuilder
                type = NavType.IntType
            },
            navArgument("pokemonName") {
                type = NavType.StringType
            }
        )
    ) {
        // content - composable 정의
        // it : NavBackStackEntry
        val dominantColor = remember {
            val color = it.arguments?.getInt("dominantColor")
            color?.let{ Color(it) } ?: Color.White
        }
        val pokemonName = remember {
            it.arguments?.getString("pokemonName")
        }
    }
}
```

