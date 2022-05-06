import {createStackNavigator} from "react-navigation-stack"
import {createAppContainer} from "react-navigation"
import Register from "../screens/Register"
import Login from "../screens/Login";

const stackNavigatorOptions = {
  headerShown: false
}

const AppNavigator = createStackNavigator({
  Login:{screen:Login},
  Register:{screen:Register},
  },
  {
    defaultNavigationOptions: stackNavigatorOptions
  }
)

export default createAppContainer(AppNavigator)