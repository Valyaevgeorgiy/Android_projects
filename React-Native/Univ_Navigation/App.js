import Constants from 'expo-constants';
import {Button, StyleSheet, Text, View, Image} from 'react-native';

import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { createDrawerNavigator } from '@react-navigation/drawer';

const data = [
    {
        title: "Foundawtion: творческий проект Сенегала",
        body: "Foundawtion – это инициатива, в рамках которой группа талантливых архитекторов превратила юг Сенегала в творческий эпицентр.",
        imgUrl: "http://brightmagazine.ru/wp-content/uploads/2022/03/pexels-hello-massamba-10509940-768x512.jpg"
    },
    {
        title: "Гитхорн: уголок в Нидерландах, где совсем нет автомобилей",
        body: "Десятки каналов и 176 мостов – богатство спокойной голландской деревушки Гитхорн. Там почтальон привозит письма на лодке, а автомобилей нет и в помине. Идеальное место, чтобы отдохнуть от городского шума и суеты.",
        imgUrl: "http://brightmagazine.ru/wp-content/uploads/2022/03/pexels-tanathip-rattanatum-2026451-768x512.jpg"
    },
    {
        title: "Самые лучшие страны мира для путешествий в одиночку",
        body: "Иногда в путешествие хочется отправиться в одиночку, чтобы побыть наедине с самим собой и найти ответы на жизненные вопросы. Сегодня мы расскажем вам о самых безопасных странах мира именно для таких путешествий.",
        imgUrl: "http://brightmagazine.ru/wp-content/uploads/2022/02/pexels-valentin-antonucci-691637-768x512.jpg"
    }
]

const Stack = createNativeStackNavigator();
const Drawer = createDrawerNavigator();

// Главный экран
const MainScreen = ({ navigation, route }) => {
    return (
        <View style={styles.container}>
            <Text style={styles.header}>{data[0].title}</Text>
            <Image source={{ uri: data[0].imgUrl }} style={styles.logoStyle}/>
            <Text style={styles.body}>{data[0].body}</Text>
            <View style={styles.button_view}>
                <Button title="Следующая страница"
                        onPress={() => navigation.push('Вторая страница', { screen: "Вторая" })} color="#000"/>
            </View>
            <Text style={styles.bold_text}>{route.params.screen} экран</Text>
        </View>
    );
};

// Второй экран
const SecondScreen = ({ navigation, route }) => {
    return (
        <View style={styles.container}>
            <Text style={styles.header}>{data[1].title}</Text>
            <Image source={{ uri: data[1].imgUrl }} style={styles.logoStyle}/>
            <Text style={styles.body}>{data[1].body}</Text>
            <View style={styles.button_view}>
                <Button title="Последняя страница"
                    onPress={() => navigation.push('Последняя страница', { screen: "Третья" })} color="#000"/>
            </View>
            <View style={styles.button_view_2}>
                <Button title="Назад" onPress={() => navigation.goBack()} color="#000"/>
            </View>
        </View>
    );
};

// Третий экран
const ThirdScreen = ({ navigation, route }) => {
    return (
        <View style={styles.container}>
            <Text style={styles.header}>{data[2].title}</Text>
            <Image source={{ uri: data[2].imgUrl }} style={styles.logoStyle}/>
            <Text style={styles.body}>{data[2].body}</Text>
            <View style={styles.button_view}>
                <Button title="Перейти на первую страницу" onPress={() =>
                    navigation.push('Первая страница', { screen: "Главный" })} color="#000"/>
            </View>
            <View style={styles.button_view}>
                <Button title="Назад" onPress={() => navigation.goBack()} color="#000"/>
            </View>
            <View style={styles.button_view}>
                <Button title="На главную страницу" onPress={() => navigation.popToTop()} color="#000"/>
            </View>
        </View>
    );
};

// Указываем везде initialParams для доступа к route.params.screen
// (из-за того, что Drawer.Navigator просто возвращает экран, а передача доп параметра screen происходит в кнопке )
function DrawerNavigation() {
    return (
        <Drawer.Navigator>
            <Drawer.Screen name="Первая страница" component={MainScreen} initialParams={{ screen: "Первая"}}/>
            <Drawer.Screen name="Вторая страница" component={SecondScreen} initialParams={{ screen: "Вторая"}}/>
            <Drawer.Screen name="Последняя страница" component={ThirdScreen} initialParams={{ screen: "Третья"}}/>
        </Drawer.Navigator>
    )
}

export default function App() {
    return (
        <NavigationContainer>
            <Stack.Navigator>
                {/* Первым подключаем Drawer Navigator как вложенный в Stack Navigator */}
                <Stack.Screen name="DrawerNavigator" component={DrawerNavigation} options={{ headerShown: false }}/>
                <Stack.Screen name="Первая страница" component={MainScreen} />
                <Stack.Screen name="Вторая страница" component={SecondScreen} />
                <Stack.Screen name="Последняя страница" component={ThirdScreen} />
            </Stack.Navigator>
        </NavigationContainer>
    );
}

const styles = StyleSheet.create({
    container: {
        paddingTop: Constants.statusBarHeight,
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
    button_view: {
        margin: 10,
    },
    button_view_2: {
        margin: 10
    },
    bold_text: {
        margin: 10,
        fontSize: 18,
        fontWeight: "bold",
    },
    logoStyle: {
        width: 350,
        height: 220,
        marginLeft: 20,
        borderRadius: 15
    },
    header: {
        color: 'black',
        fontSize: 28,
        fontWeight: "bold",
        marginBottom: 20,
        marginLeft: 20,
        marginTop: 10,
    },
    body: {
        color: 'black',
        fontSize: 18,
        marginLeft: 20,
        marginTop: 25,
        marginRight: 40
    }
});