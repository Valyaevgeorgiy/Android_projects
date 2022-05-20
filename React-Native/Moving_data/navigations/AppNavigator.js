import {createStackNavigator} from "react-navigation-stack"
import {createAppContainer} from "react-navigation"
import Register from "../screens/Register"
import Login from "../screens/Login";
import Profile from "../screens/Profile"

const stackNavigatorOptions = {
  headerShown: false
}

const AppNavigator = createStackNavigator({
      Login:{screen:Login},
      Register:{screen:Register},
      Profile:{screen:Profile},
    },
    {
      defaultNavigationOptions: stackNavigatorOptions
    }
)

export default createAppContainer(AppNavigator)