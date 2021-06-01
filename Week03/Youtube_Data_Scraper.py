#!/Users/luisherre/opt/anaconda3/bin/python

from requests_html import HTMLSession 
from bs4 import BeautifulSoup as bs # importing BeautifulSoup
import argparse

def main():
    # get command line args
    parser = argparse.ArgumentParser(description="YouTube Video View Scraper")
    parser.add_argument("search", help="same as YT search bar")
    args = parser.parse_args()
    search_term = args.search
    print("searching for " + search_term + "...\n")

    # get video links from search query
    links = get_video_links(search_term)

    # making sure entries are unique
    links = list(set(links))

    print("scraping data for 5 videos...\nThis may take a minute...\n")
    data = []
    for link in links[:5]:
        print("scraping...\n")
        data.append(get_video_data(link))

    # displaying results
    print("Displaying Results:")
    for entry in data:
        print(f"Title: {entry['title']}")
        print(f"Views: {entry['views']}")
        print(f"\n---------------------------\n")

def get_video_links(search_term):
    # init HTML session
    session = HTMLSession()
    # download HTML code
    response = session.get('https://www.youtube.com/results?search_query='+search_term)
    # execute Javascript
    response.html.render(sleep=1)
    # create beautiful soup object to parse HTML
    soup = bs(response.html.html, "html.parser")

    links = []
    vid_links = []
    for link in soup.find_all('a'):
        if link.get('href') != None:
            links.append(link.get('href'))
    for link in links:
        if ('/watch?v=' in link) and (len(link) == 20): # only add youtube video links
            vid_links.append(link)            
    
    return vid_links

def get_video_data(href):
    session = HTMLSession()
    response = session.get('https://www.youtube.com' + href)
    response.html.render(sleep=1)
    soup = bs(response.html.html, "html.parser")

    # store video metadata in dictionary
    result = {}
    result["title"] = soup.find("h1").text.strip()
    result["views"] = int(''.join([ c for c in soup.find("span", attrs={"class": "view-count"}).text if c.isdigit() ]))
    result["description"] = soup.find("yt-formatted-string", {"class": "content"}).text
    
    return result

if __name__ == "__main__":
    main()