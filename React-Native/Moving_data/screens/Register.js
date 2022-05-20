import React from "react"
import {Text, View, Image, TextInput, TouchableOpacity, Alert} from 'react-native';
import Icon from "@expo/vector-icons/AntDesign"

export default class Register extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      UserName: "",
      UserEmail: "",
      UserPassword: ""
    }
  }

  goToLogin = () => {
    const {navigate} = this.props.navigation
    navigate("Login", {
      email: this.state.UserEmail,
      password: this.state.UserPassword,
    })
  }

  UserRegistrationFunction = () => {
    const { UserName }  = this.state ;
    const { UserEmail }  = this.state ;
    const { UserPassword }  = this.state ;

    fetch('http://192.168.1.2:8000', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        name: UserName,
        email: UserEmail,
        password: UserPassword
      })

    }).then((response) => response.json())
        .then((responseJson) => {
          // Showing response message coming from server after inserting records.
          if (responseJson === "User Registered Successfully") {
            Alert.alert(responseJson)
            this.goToLogin()
          }
          Alert.alert(responseJson);
        }).catch((error) => {
      console.error(error);
    });


  }

  render() {
    return (
        <View style={{ backgroundColor: "#fff", height: "100%", justifyContent: 'center', alignItems: 'center' }}>
          <Image source={require("../assets/register.png")}
                 style={{ width: 160, height: 300 }}/>
          <Text style={{ fontSize: 30, fontFamily: "SemiBold", alignSelf: "center" }}>
            Регистрация
          </Text>
          <Text style={{
            fontFamily: "Regular",
            marginHorizontal: 55,
            textAlign: "center",
            marginTop: 5,
            opacity: 0.6,
            fontSize: 15,
          }}>
            Введите свои персональные данные для повышения персонализации.
            Это необходимо только один раз.
          </Text>
          <View style={{
            flexDirection:"row",
            alignItems:"center",
            marginHorizontal: 55,
            borderWidth: 2,
            marginTop: 30,
            paddingHorizontal: 10,
            borderColor: "#32CD32",
            borderRadius: 23,
            paddingVertical: 2,
          }}>
            <Icon name="user" color="#32CD32" size={24} />
            <TextInput style={{ paddingHorizontal: 10 }} onChangeText={UserName => this.setState({UserName})} placeholder="Имя пользователя" />
          </View>
          <View style={{
            flexDirection:"row",
            alignItems:"center",
            marginHorizontal: 55,
            borderWidth: 2,
            marginTop: 10,
            paddingHorizontal: 10,
            borderColor: "#32CD32",
            borderRadius: 23,
            paddingVertical: 2,
          }}>
            <Icon name="mail" color="#32CD32" size={24} />
            <TextInput style={{ paddingHorizontal: 10 }} onChangeText={UserEmail => this.setState({UserEmail})} placeholder="Email" />
          </View>
          <View style={{
            flexDirection:"row",
            alignItems:"center",
            marginHorizontal: 55,
            borderWidth: 2,
            marginTop: 10,
            paddingHorizontal: 10,
            borderColor: "#32CD32",
            borderRadius: 23,
            paddingVertical: 2,
          }}>
            <Icon name="lock" color="#32CD32" size={24} />
            <TextInput style={{ paddingHorizontal: 10 }} onChangeText={UserPassword => this.setState({UserPassword})} placeholder="Пароль" secureTextEntry />
          </View>
          <View style={{ marginHorizontal: 55, alignItems: "center" }} >
            <TouchableOpacity style={{
              backgroundColor: "#32CD32",
              height: 45,
              marginTop: 20,
              borderRadius: 15,
              alignItems: "center",
            }} onPress={this.UserRegistrationFunction}>
              <Text style={{
                color: "white",
                padding: 12,
                paddingHorizontal: 20,
                fontWeight: "bold",
                fontSize: 16,
              }}>
                Зарегистрироваться
              </Text>
            </TouchableOpacity>
          </View>
          <View style={{ marginHorizontal: 55, alignItems: "center" }} >
            <TouchableOpacity style={{
              backgroundColor: "white",
              height: 25,
              marginTop: 12,
              borderRadius: 0,
              alignItems: "center",
            }} onPress={() => this.goToLogin()}>
              <Text style={{
                fontFamily: "Medium",
                fontSize: 16,
              }}>
                Уже есть регистрация? Войти
              </Text>
            </TouchableOpacity>
          </View>
        </View>
    )
  }
}
