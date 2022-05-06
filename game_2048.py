import random
import pygame
from sys import exit
from copy import deepcopy
from pygame.locals import *

board = [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
pygame.init()

score, box_size, box_gap, top_of_screen, bottom_of_screen, left_of_screen = 0, 100, 5, 100, 20, 50
screen_width, screen_height = 520, 550
screen = pygame.display.set_mode((screen_width, screen_height), 0, 32)
programIcon = pygame.image.load('icon.png')
pygame.display.set_icon(programIcon)
pygame.display.set_caption("Игра «2048»")
background = pygame.image.load('background.png').convert()

class Box:

    def __init__(self, topleft, text, color):
        self.topleft = topleft
        self.text = text
        self.color = color

    def render(self, surface):
        x, y = self.topleft
        pygame.draw.rect(surface, self.color, (x, y, box_size, box_size), 0)
        text_height = 35
        font_obj = pygame.font.SysFont("Comic_Sans", text_height)
        text_surface = font_obj.render(self.text, True, (0, 0, 0))
        text_rect = text_surface.get_rect()
        text_rect.center = (x + 50, y + 50)
        surface.blit(text_surface, text_rect)

def draw_box():
    colors = {0: (192, 192, 192), 2: (255, 255, 240), 4: (255, 250, 205), 8: (255, 165, 79), 16: (250, 128, 114),
              32: (255, 69, 0), 64: (238, 0, 0), 128: (238, 230, 133), 256: (255, 245, 0), 512: (238, 238, 0),
              1024: (255, 255, 0), 2048: (255, 106, 106)}

    x, y, size = left_of_screen, top_of_screen, 425
    pygame.draw.rect(screen, (0, 0, 0), (x, y, size, size))
    x, y = x + box_gap, y + box_gap

    for i in range(4):
        for j in range(4):
            idx = board[i][j]
            if idx == 0:
                text = ""
            else:
                text = str(idx)
            if idx > 2048:
                idx = 2048
            color = colors[idx]
            box = Box((x, y), text, color)
            box.render(screen)
            x += box_size + box_gap
        x = left_of_screen + box_gap
        y += top_of_screen + box_gap

def set_random_number():
    num = []
    for i in range(4):
        for j in range(4):
            if board[i][j] == 0:
                num.append((i, j))
    m = random.choice(num)
    num.remove(m)
    value = random.uniform(0, 1)
    if value < 0.1:
        value = 4
    else:
        value = 2
    board[m[0]][m[1]] = value

def init_board():
    for i in range(2):
        set_random_number()

def combinate(L):
    global score
    ans = [0, 0, 0, 0]
    num = []
    for i in L:
        if i != 0:
            num.append(i)
    length = len(num)
    if length == 4:
        if num[0] == num[1]:
            ans[0] = num[0] + num[1]
            score += ans[0]
            if num[2] == num[3]:
                ans[1] = num[2] + num[3]
                score += ans[1]
            else:
                ans[1] = num[2]
                ans[2] = num[3]
        elif num[1] == num[2]:
            ans[0] = num[0]
            ans[1] = num[1] + num[2]
            ans[2] = num[3]
            score += ans[1]
        elif num[2] == num[3]:
            ans[0] = num[0]
            ans[1] = num[1]
            ans[2] = num[2] + num[3]
            score += ans[2]
        else:
            for i in range(length):
                ans[i] = num[i]
    elif length == 3:
        if num[0] == num[1]:
            ans[0] = num[0] + num[1]
            ans[1] = num[2]
            score += ans[0]
        elif num[1] == num[2]:
            ans[0] = num[0]
            ans[1] = num[1] + num[2]
            score += ans[1]
        else:
            for i in range(length):
                ans[i] = num[i]
    elif length == 2:
        if num[0] == num[1]:
            ans[0] = num[0] + num[1]
            score += ans[0]
        else:
            for i in range(length):
                ans[i] = num[i]
    elif length == 1:
        ans[0] = num[0]
    else:
        pass
    return ans

def left():
    for i in range(4):
        temp = combinate(board[i])
        for j in range(4):
            board[i][j] = temp[j]

def right():
    for i in range(4):
        temp = combinate(board[i][::-1])
        for j in range(4):
            board[i][3 - j] = temp[j]

def up():
    for i in range(4):
        to_comb = []
        for j in range(4):
            to_comb.append(board[j][i])
        temp = combinate(to_comb)
        for k in range(4):
            board[k][i] = temp[k]

def down():
    for i in range(4):
        to_comb = []
        for j in range(4):
            to_comb.append(board[3 - j][i])
        temp = combinate(to_comb)
        for k in range(4):
            board[3 - k][i] = temp[k]

def write(msg="Winning!!!", color=(255, 0, 0), height=14):
    myfont = pygame.font.SysFont("Comic_Sans", height)
    mytext = myfont.render(msg, True, color)
    mytext = mytext.convert_alpha()
    return mytext

def is_over():
    for i in range(4):
        for j in range(4):
            if board[i][j] == 0:
                return False
    for i in range(4):
        for j in range(3):
            if board[i][j] == board[i][j + 1]:
                return False
    for i in range(3):
        for j in range(4):
            if board[i][j] == board[i + 1][j]:
                return False
    return True

def main():
    global score
    global board
    screen.blit(background, (0, 0))
    init_board()
    newboard, gameover = deepcopy(board), is_over()
    draw_box()
    screen.blit(write("2048", height=55, color=(255, 255, 255)), (left_of_screen - 35, left_of_screen // 2 - 20))
    screen.blit(write("score", height=35, color=(255, 255, 255)), (left_of_screen + 255, left_of_screen // 2 - 25))
    while True:
        for event in pygame.event.get():
            gameover = is_over()
            if event.type == QUIT or (event.type == KEYUP and event.key == K_ESCAPE):
                pygame.quit()
                exit()
            elif not gameover:
                if event.type == KEYUP and event.key == K_UP:
                    up()
                elif event.type == KEYUP and event.key == K_DOWN:
                    down()
                elif event.type == KEYUP and event.key == K_LEFT:
                    left()
                elif event.type == KEYUP and event.key == K_RIGHT:
                    right()
                if newboard != board:
                    set_random_number()
                    newboard = deepcopy(board)
                    draw_box()
            else:
                screen.blit(write("Game Over!", height=40, color=(0, 0, 0)), (left_of_screen + 140, screen_height // 2))
                if event.type == KEYUP and event.key == K_SPACE:
                    gameover = False
                    score = 0
                    board = [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
                    init_board()
                    set_random_number()
                    newboard = deepcopy(board)
                    draw_box()

        pygame.display.update()
        rect1 = pygame.draw.rect(screen, (8, 16, 115), (left_of_screen + 258, left_of_screen // 2 + 30, 83, 25))
        text1 = write(str(score), height=20, color=(255, 228, 0))
        text_rect = text1.get_rect()
        text_rect.center = (left_of_screen + 300, left_of_screen // 2 + 41)
        screen.blit(text1, text_rect)


if __name__ == "__main__":
    main()