import React from "react";
import {AppRegistry, StyleSheet, View, TouchableOpacity, Alert, TextInput, ImageBackground, Text} from "react-native";

export default class App extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            name: "",
        }
    }

    render() {
        return  (
            <View style={styles.container}>
                <ImageBackground source={{uri: "https://thumbs.dreamstime.com/b/%D0%B2%D0%B5%D1%80%D1%82%D0%B8%D0%BA%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B9-%D1%84%D0%BE%D0%BD-%D1%86%D0%B8%D1%80%D0%BA%D0%BE%D0%B2%D1%8B%D1%85-%D0%BE%D0%B1%D0%BB%D0%B0%D0%BA%D0%BE%D0%B2-%D0%BD%D0%B0-%D0%B3%D0%BE%D0%BB%D1%83%D0%B1%D0%BE%D0%BC-%D0%BD%D0%B5%D0%B1%D0%B5-%D1%80%D0%BE%D1%81%D1%81%D0%B8%D1%8F-%D1%84%D1%80%D0%B0%D0%B3%D0%BC%D0%B5%D0%BD%D1%82-158574309.jpg"}} resizeMode="cover" style={styles.image}>
                    <View style={{
                        flexDirection:"row",
                        alignItems:"center",
                        marginHorizontal: 55,
                        borderWidth: 3,
                        marginTop: 30,
                        textAlign: "center",
                        paddingHorizontal: 20,
                        borderColor: "#00FF00",
                        borderRadius: 28,
                        paddingVertical: 10,
                    }}>
                        <TextInput
                            onChangeText={name => this.setState({name})}
                            placeholder="Введите любой текст"/>
                    </View>
                    <View style={{ marginTop: 80, alignItems: "center", justifyContent: "center"}}>
                        <TouchableOpacity style={styles.button} onPress={() => Alert.alert("Вы ввели следующее: " + this.state.name)}>
                            <Text>Нажми на меня или на Enter</Text>
                        </TouchableOpacity>
                    </View>
                </ImageBackground>
            </View>
        )
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        paddingTop: 30,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
    image: {
        flex: 1,
        justifyContent: "center"
    },
    button: {
        width: "80%",
        borderRadius: 25,
        height: 50,
        alignItems: "center",
        justifyContent: "center",
        marginTop: 10,
        backgroundColor: "#87CEFA",
    }
});

