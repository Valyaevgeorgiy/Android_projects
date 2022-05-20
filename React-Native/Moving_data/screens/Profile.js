import React from "react"
import {View, Text, TouchableOpacity} from "react-native"

export default class Profile extends React.Component {
  render() {
    return (
      <View style={{ justifyContent: 'center', flex: 1, margin: 10}}>
        <View style={{ backgroundColor: "steelblue", borderRadius: 30 }}>
          <Text style={{ fontFamily: "SemiBold", fontSize: 20, alignSelf: "center", marginTop: 20 }}>
            Ваш email: {this.props.navigation.getParam("email", "")}
          </Text>
          <Text style={{ fontFamily: "SemiBold", fontSize: 20, alignSelf: "center", margin: 20 }}>
            Ваш пароль: {this.props.navigation.getParam("password", "")}
          </Text>
        </View>
        <View style={{ marginHorizontal: 55, alignItems: "center", marginTop: 20 }} >
          <TouchableOpacity style={{
            backgroundColor: "teal",
            height: 45,
            marginTop: 20,
            borderRadius: 15,
            alignItems: "center",
          }} onPress={() => this.props.navigation.goBack()}>
            <Text style={{
              color: "white",
              padding: 12,
              paddingHorizontal: 20,
              fontWeight: "bold",
              fontSize: 16,
            }}>
              Выйти из аккаунта
            </Text>
          </TouchableOpacity>
        </View>
      </View>
    )
  }
}