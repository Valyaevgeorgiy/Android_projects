import React from "react"
import {Text, View, Image, TextInput, TouchableOpacity, Alert} from 'react-native';
import Icon from "@expo/vector-icons/AntDesign"

export default class Login extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      UserEmail: "",
      UserPassword: ""
    }
  }

  goToRegister = () => {
    const {navigate} = this.props.navigation
    navigate("Register")
  }

  goToProfile = () => {
    const {navigate} = this.props.navigation
    navigate("Profile", {
      email: this.state.UserEmail,
      password: this.state.UserPassword,
    })
  }

  UserLoginFunction = () => {
    const { UserEmail }  = this.state;
    const { UserPassword }  = this.state;

    fetch('http://192.168.1.2:8000/user_login.php', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        email: UserEmail,
        password: UserPassword
      })
    }).then((response) => response.json())
        .then((responseJson) => {
          // If server response message same as Data Matched
          if (responseJson === "Data Matched") {
            //Then open Profile activity and send user email to profile activity.
            this.goToProfile()
          }
          else{
            Alert.alert(responseJson);
          }
        }).catch((error) => {
      console.error(error);
    });


  }

  render() {
    return (
        <View style={{ backgroundColor: "#fff", height: "100%", width: "100%" }}>
          <Image source={require("../assets/login.png")}
                 style={{ width: "70%", height: "45%", alignSelf: "center",
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
            <Icon name="mail" color="#DAA520" size={24} />
            <TextInput style={{ paddingHorizontal: 10 }}
                       onChangeText={UserEmail => this.setState({UserEmail})}
                       placeholder="Email">
              {this.props.navigation.getParam("email", "")}
            </TextInput>
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
            <TextInput style={{ paddingHorizontal: 10 }}
                       onChangeText={UserPassword => this.setState({UserPassword})}
                       placeholder="Пароль" secureTextEntry>
              {this.props.navigation.getParam("password", "")}
            </TextInput>
          </View>
          <View style={{ marginHorizontal: 55, alignItems: "center" }} >
            <TouchableOpacity style={{
              backgroundColor: "#DAA520",
              height: 45,
              marginTop: 20,
              borderRadius: 15,
              alignItems: "center",
            }} onPress={this.UserLoginFunction}>
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
                fontSize: 14,
              }}>
                Нет аккаунта? Зарегистрироваться
              </Text>
            </TouchableOpacity>
          </View>
        </View>
    )
  }
}
