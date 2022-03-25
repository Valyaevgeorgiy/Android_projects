import { Text, View, StyleSheet, Image } from 'react-native';
import * as React from 'react';

export default function Picture() {
    return (
        <View style={styles.container}>
            <Image style={styles.logo} source={require('../assets/five_words.png')} />
            <Text style={styles.header}>
                Пять непереводимых слов из разных уголков мира
            </Text>
            <Text style={styles.paragraph}>
                В каждом языке есть такие слова, которые невозможно перевести на другой язык одним
                конкретным словом. Это скорее целые культурные явления, которые часто в полной мере понятны
                только жителям определенных стран.
            </Text>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        alignItems: 'center',
        justifyContent: 'center',
        padding: 24,
    },
    header: {
        margin: 30,
        fontSize: 20,
        fontWeight: 'bold',
        textAlign: 'center',
    },
    paragraph: {
        fontSize: 14,
        fontWeight: 'normal',
        textAlign: 'center',
    },
    logo: {
        height: 300,
        width: 300,
    }
});