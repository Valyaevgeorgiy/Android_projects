import {Text, View, StyleSheet} from 'react-native';
import Constants from 'expo-constants';
import * as React from 'react';

export default function App() {
  return (
      <View style={styles.container}>
        <View style={{ flex: 1, backgroundColor: '#FFDEAD' }}>
          <Text style={styles.paragraph}>Праздники без диет:
          как не набрать вес в период зимних торжеств</Text>
        </View>
        <View style={{ flex: 3, backgroundColor: '#DEB887' }}>
          <Text style={styles.smallone}>
            Что стоит поставить на новогодний стол, чтобы сохранить форму? Как правильно организовать своё
            время в самую долгожданную ночь года, не набрав лишние килограммы? Что ещё следует сделать,
            чтобы после зимних праздников быть не только в прекрасном настроении, но и в отличной форме? На
            эти вопросы отвечает нутрициолог, консультант по коррекции пищевого поведения Мария Высоцкая.
          </Text>
        </View>
        <View style={{ flex: 3, backgroundColor: '#FFE4C4' }}>
          <Text style={styles.smalltwo}>
            Многие привыкли готовить “тазик” салата, несколько видов горячего и десертов. Поскольку есть всё
            это предстоит вечером или вообще ночью, не следует готовить множество разнообразных блюд.
            Достаточно сделать по одному виду салата и горячего. В качестве десерта можно использовать
            фрукты, но не торты и пирожные. Так, вы убережёте себя и гостей от переедания за праздничным
            столом.
          </Text>
          <View style={styles.buttonContainer}>
            <Text style={styles.next}>
              ЧИТАТЬ ДАЛЕЕ
            </Text>
          </View>
        </View>
      </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    paddingTop: Constants.statusBarHeight,
  },
  paragraph: {
    margin: 25,
    fontSize: 18,
    fontWeight: 'bold',
    textAlign: 'center',
  },
  smallone: {
    marginTop: 50,
    marginHorizontal: 20,
    fontSize: 15,
    fontWeight: 'normal',
    textAlign: 'center',
  },
  smalltwo: {
    marginTop: 50,
    marginHorizontal: 20,
    fontSize: 15,
    fontWeight: 'normal',
    textAlign: 'center',
  },
  buttonContainer: {
    elevation: 10,
    margin: 20,
    marginHorizontal: 60,
    backgroundColor: '#F0E68C',
    borderRadius: 10,
    padding: 15,
  },
  next: {
    fontSize: 18,
    fontWeight: 'normal',
    textAlign: 'center',
  },
});