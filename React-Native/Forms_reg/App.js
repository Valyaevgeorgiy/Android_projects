import React from "react";
import AppNavigator from "./navigations/AppNavigator";
import 'react-native-gesture-handler';
import * as Font from "expo-font"
import AppLoading from "expo-app-loading"

export default class App extends React.Component {
  state = {
    isFontLoaded: false
  }

  async componentDidMount() {
    await Font.loadAsync({
      "SemiBold": require("./fonts/Montserrat-SemiBold.otf"),
      "Medium": require("./fonts/Montserrat-Medium.otf"),
      "Regular": require("./fonts/Montserrat-Regular.otf"),
    })
    this.setState({isFontLoaded:true})
  }

  render() {
    return (
        (this.state.isFontLoaded === true) ? (<AppNavigator/>):(<AppLoading/>)
    )
  }
}