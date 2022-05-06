import React from "react"
import {Text, View, Image, TextInput, TouchableOpacity, Alert} from 'react-native';
import Icon from "@expo/vector-icons/AntDesign"

export default class Login extends React.Component {
  goToRegister = () => {
    const {navigate} = this.props.navigation
    navigate("Register")
  }

  render() {
    return (
        <View style={{ backgroundColor: "#fff", height: "100%", width: "100%" }}>
          <Image source={require("../assets/login.png")}
                 style={{ width: "80%", height: "45%", alignSelf: "center",
                 alignItems: "center", alignContent: "center", marginBottom: 10,
                 marginTop: 60}}/>
          <Text style={{ fontSize: 30, fontFamily: "SemiBold", alignSelf: "center" }}>
            Вход
          </Text>
          <Text style={{
            fontFamily: "Regular",
            marginHorizontal: 55,
            textAlign: "center",
            marginTop: 5,
            opacity: 0.6,
            fontSize: 16,
          }}>
            Введите логин и пароль, который создавали ранее при регистрации.
          </Text>
          <View style={{
            flexDirection:"row",
            alignItems:"center",
            marginHorizontal: 55,
            borderWidth: 2,
            marginTop: 10,
            paddingHorizontal: 10,
            borderColor: "#DAA520",
            borderRadius: 23,
            paddingVertical: 2,
          }}>
            <Icon name="login" color="#DAA520" size={24} />
            <TextInput style={{ paddingHorizontal: 10 }} placeholder="Логин" />
          </View>
          <View style={{
            flexDirection:"row",
            alignItems:"center",
            marginHorizontal: 55,
            borderWidth: 2,
            marginTop: 10,
            paddingHorizontal: 10,
            borderColor: "#DAA520",
            borderRadius: 23,
            paddingVertical: 2,
          }}>
            <Icon name="lock" color="#DAA520" size={24} />
            <TextInput style={{ paddingHorizontal: 10 }} placeholder="Пароль" secureTextEntry />
          </View>
          <View style={{ marginHorizontal: 55, alignItems: "center" }} >
            <TouchableOpacity style={{
              backgroundColor: "#DAA520",
              height: 45,
              marginTop: 20,
              borderRadius: 15,
              alignItems: "center",
            }} onPress={() => Alert.alert("Успешный вход")}>
              <Text style={{
                color: "white",
                padding: 12,
                paddingHorizontal: 20,
                fontWeight: "bold",
                fontSize: 16,
              }}>
                Войти
              </Text>
            </TouchableOpacity>
          </View>
          <View style={{ marginHorizontal: 55, alignItems: "center" }} >
            <TouchableOpacity style={{
              backgroundColor: "white",
              height: 25,
              marginTop: 20,
              borderRadius: 0,
              alignItems: "center",
            }} onPress={() => this.goToRegister()}>
              <Text style={{
                fontFamily: "Medium",
                color: "black",
                fontSize: 12,
              }}>
                Нет аккаунта? Зарегистрироваться
              </Text>
            </TouchableOpacity>
          </View>
        </View>
    )
  }
}
